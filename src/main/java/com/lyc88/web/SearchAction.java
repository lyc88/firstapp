package com.lyc88.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyc88.beans.DiskFilesSolrBean;
import com.lyc88.beans.QueryBean;
import com.lyc88.services.SearchService;
import com.lyc88.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.wicket.markup.html.image.Image;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/28.
 */
@Controller
@RequestMapping("search")
public class SearchAction {
    @Resource
    private SearchService searchService;

    @RequestMapping("toSearch")
    public String toSearch(Model model){
        QueryBean queryBean = new QueryBean();
        Page page = new Page();
        queryBean.setPage(page);
        queryBean.setFact("fileSize,fileType");
        Map map = searchService.query(queryBean);
        model.addAttribute("page",page);
        model.addAttribute("map",map);
        return "search";
    }

    /**
     * 搜索
     * @return
     */
    @RequestMapping("searchAll/{currentPage}")
    @ResponseBody
    public Map search(@PathVariable String currentPage,String q) throws IOException {
        QueryBean queryBean = new QueryBean();
        if(StringUtils.isNotBlank(q)){
            queryBean.setQ("all:"+q);
        }
        queryBean.setFact("fileSize,fileType");
        Page page = new Page();
        page.setCurrentPage(Integer.valueOf(currentPage).intValue());
        queryBean.setPage(page);
        Map map = searchService.query(queryBean);
        List<FacetField> facetFields = (List<FacetField>) map.get("listFact");
        map.remove("listFact");
        //map.put("fact",object);
        // ObjectMapper mapper = new ObjectMapper();
        // StringWriter json=new StringWriter();
        //mapper.writeValue(json,map);

        //List<FacetField> facetFields 这种类型过于复杂 Jackson 转换不了栈溢出
        List list = new ArrayList<>();
        for(FacetField facetField:facetFields){
            Map map1  = new HashMap<>();

            map1.put("desc",facetField.getName());
            List list1 = new ArrayList<>();

            for(FacetField.Count count:facetField.getValues()){
                Map map2 = new HashMap<>();
                map2.put("name",count.getName());
                map2.put("value",count.getCount());
                list1.add(map2);
            }
            map1.put("value",list1);
            list.add(map1);
        }
        map.put("listFact",list);
        return map;
    }

    @RequestMapping("toEchartDemo01")
    public String toEchartDemo01(Model model){
        try {
            int j = 0;
            int i = 1/j;
        }catch (Exception e){

        }

        return "echartDemo01";
    }

    @RequestMapping("toExportDocx")
    public void toExportDocx(HttpServletRequest request, Model model, HttpServletResponse response, @RequestParam MultipartFile image) throws InvalidFormatException, IOException {
       /* WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
        wordMLPackage.getMainDocumentPart().addParagraphOfText("Hello Word!");
        wordMLPackage.getMainDocumentPart().addObject(image);
        File file =  new java.io.File("src/main/files/HelloWord1.docx");
        response.setContentType("application/msword");
        String fileName = "导出";
        response.setHeader("content-disposition", "attachment;filename=" + new String(fileName.getBytes(),"ISO8859-1") + ".doc");

        System.out.println("开始");
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName1 = image.getOriginalFilename();
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        try {
            image.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            wordMLPackage.save(response.getOutputStream());
        } catch (Docx4JException e) {
            e.printStackTrace();
        }*/
    }


}
