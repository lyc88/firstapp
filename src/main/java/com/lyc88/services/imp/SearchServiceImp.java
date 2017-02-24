package com.lyc88.services.imp;

import com.lyc88.beans.DiskFiles;
import com.lyc88.beans.DiskFilesSolrBean;
import com.lyc88.beans.QueryBean;
import com.lyc88.dao.DiskFilesDao;
import com.lyc88.services.SearchService;
import com.lyc88.services.SubjectService;
import com.lyc88.utils.Page;
import com.lyc88.utils.SolrServer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.StringUtils;
import org.apache.solr.common.util.NamedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2017/1/27.
 */
@Service("searchService")
public class SearchServiceImp implements SearchService {
    @Resource
    private DiskFilesDao diskFilesDao;

    @Override
    public void addIndex() {
        HttpSolrClient httpSolrClient = SolrServer.getServer();
        long total = diskFilesDao.getTotal();
        //System.out.println(total);
        long start = System.currentTimeMillis();
        Page page = new Page(total,5000);
        addIndex(httpSolrClient,1,page.getTotalPage(),page);
        //addIndex(httpSolrClient,1,1,page);
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000);

    }

    @Override
    public void mulAddIndex() {

        long total = diskFilesDao.getTotal();
        long start = System.currentTimeMillis();
        Page page = new Page(total,1000);
        int totalPage = page.getTotalPage();
        int threadNum = 3;
        int pages = totalPage/3;
       /* for(int i=1;i<=3;i++){

        }*/

        new Thread(new SearchServiceImp().new MulThread(1,pages)).start();
        new Thread(new SearchServiceImp().new MulThread(pages+1,pages*2)).start();
        new Thread(new SearchServiceImp().new MulThread(pages*2+1,totalPage)).start();
    }

    private void addIndex(HttpSolrClient httpSolrClient,int start,int end,Page page){
        for(int i=start;i<=end;i++) {
            List<DiskFilesSolrBean> diskFilesSolrBeanList = new ArrayList<DiskFilesSolrBean>();
            page.setCurrentPage(i);
            if (diskFilesDao == null) {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
                diskFilesDao = (DiskFilesDao) applicationContext.getBean("diskFilesDao");
            }
            List<DiskFiles> diskFilesList = diskFilesDao.getPage(page);
            for (DiskFiles diskFiles : diskFilesList) {
                diskFilesSolrBeanList.add(diskFilesToDiskFilesSolrBean(diskFiles));
            }

            /*Iterator<DiskFilesSolrBean> iterator= diskFilesSolrBeanList.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }*/
            try {
                httpSolrClient.addBeans(diskFilesSolrBeanList);
                httpSolrClient.commit();
                httpSolrClient.optimize();

            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            httpSolrClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Override
    public Map query(QueryBean queryBean) {
        Map map = new HashMap<>();
        HttpSolrClient httpSolrClient = SolrServer.getServer();
        SolrQuery solrQuery = new SolrQuery();
        //搜索
        if(org.apache.commons.lang3.StringUtils.isBlank(queryBean.getQ())) {
            solrQuery.setQuery("*:*");
        }else {
            solrQuery.setQuery(queryBean.getQ());
        }
        //过滤
        if(org.apache.commons.lang3.StringUtils.isNotBlank(queryBean.getFq())) {
            solrQuery.setFilterQueries(queryBean.getFq());
        }
        //分面
        if(org.apache.commons.lang3.StringUtils.isNotBlank(queryBean.getFact())) {
            //solrQuery.addFacetField(queryBean.getFact());
            solrQuery.setFacetLimit(20);//默认100
            String[] fact = queryBean.getFact().split(",");
            if(fact.length==1){//单一排序
                solrQuery.addFacetField(fact[0]);
            }else{//多条件排序
                for(String fact1:fact){
                    solrQuery.addFacetField(fact1);
                }
            }
        }

        //排序
        if(org.apache.commons.lang3.StringUtils.isNotBlank(queryBean.getSort())){
            String[] sort = queryBean.getSort().split(",");
            if(sort.length==1){//单一排序
                String[] sort1 = sort[0].split(":");

                if(sort1[1].equals("0")) {
                    solrQuery.addSort(sort[0], SolrQuery.ORDER.asc);
                }else{
                    solrQuery.addSort(sort[0], SolrQuery.ORDER.desc);
                }
            }else{//多条件排序
                for(String sort1:sort){
                    String[] sort2 = sort1.split(":");
                    if(sort2[1].equals("0")) {
                        solrQuery.addSort(sort2[0], SolrQuery.ORDER.asc);
                    }else{
                        solrQuery.addSort(sort2[0], SolrQuery.ORDER.desc);
                    }
                }
            }
        }
        solrQuery.setHighlightSimplePre("<font color='red'>");
        solrQuery.addHighlightField("fileName");
        solrQuery.setHighlightSimplePost("</font>");
        //分页
        Page page = queryBean.getPage();
        solrQuery.setStart((page.getCurrentPage()-1)*page.getPageSize());
        solrQuery.setRows(page.getPageSize());
        List<DiskFilesSolrBean> queryResponseBeans = null;
        List<FacetField> listFact = null;
        float time = 0l;
        long numFound = 0;
        try {
            //查询
            QueryResponse queryResponse = httpSolrClient.query(solrQuery);
            time = queryResponse.getQTime();
            numFound = queryResponse.getResults().getNumFound();
            listFact = queryResponse.getFacetFields();

           /* for(FacetField facetField:listFact){
                System.out.println(facetField.getName()+"--"+facetField.getValues());
                for(FacetField.Count count:facetField.getValues()){
                    //System.out.println(count.getName()+"**"+count.getCount());
                }
            }*/
            Map<String, Map<String, List<String>>> map1 = queryResponse.getHighlighting();
            page.setTotal(numFound);
            queryResponseBeans = queryResponse.getBeans(DiskFilesSolrBean.class);

            //填充fileName 为高亮值
            for (DiskFilesSolrBean diskFilesSolrBean:queryResponseBeans){
                Map map2 = map1.get(diskFilesSolrBean.getId());
                if(map2!=null && map2.size()>0){
                    if(map2.containsKey("fileName")){
                        List list = (List) map2.get("fileName");
                        diskFilesSolrBean.setFileName(list.get(0).toString());
                    }
                }
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("queryResponseBeans",queryResponseBeans);
        map.put("page",page);
        map.put("time",time/1000);
        map.put("numFound",numFound);
        map.put("listFact",listFact);
        return map;
    }


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SearchService searchService = (SearchService) applicationContext.getBean("searchService");
        //searchService.mulAddIndex();
        searchService.addIndex();
       /* QueryBean queryBean = new QueryBean();
        Page page = new Page();
        queryBean.setPage(page);
        searchService.query(queryBean);*/
        test01("12","23");
    }

    private DiskFilesSolrBean diskFilesToDiskFilesSolrBean(DiskFiles diskFiles){
        DiskFilesSolrBean diskFilesSolrBean = new DiskFilesSolrBean();
        diskFilesSolrBean.setId(String.valueOf(diskFiles.getFileId()));
        diskFilesSolrBean.setFileType(diskFiles.getFileType());
        diskFilesSolrBean.setFilePath(diskFiles.getFilePath());
        diskFilesSolrBean.setFileName(diskFiles.getFileName());
        diskFilesSolrBean.setFileSize(Long.valueOf(diskFiles.getFileSize()));
        return diskFilesSolrBean;
    }

    private static void test01(String ... args){
        for(String a:args){
            System.out.println("---"+a+"---");
        }
    }

    /**
     * 多线程添加 所以
     */
    class MulThread implements Runnable{

        private int start;
        private int end;

        public MulThread(int start,int end){
            this.end = end;
            this.start = start;
        }
        @Override
        public void run() {
            HttpSolrClient httpSolrClient = SolrServer.getServer();
            Page page = new Page();
            page.setPageSize(1000);
            addIndex(httpSolrClient,start,end,page);
        }
    }
}
