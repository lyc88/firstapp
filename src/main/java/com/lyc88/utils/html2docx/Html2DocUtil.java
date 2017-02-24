package com.lyc88.utils.html2docx;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ListIterator;


/**
 * 工具类 将html文档转为doc
 *
 * @author dingshuag
 * @date 2016-06-06
 */
public class Html2DocUtil {

    private static final Logger log = LoggerFactory.getLogger(Html2DocUtil.class);

    private static String CHAR_SET = "utf-8";//编码格式

    /**
     * 生成word文档，如果返回null，则表示生成失败
     *
     * @param fileName
     * @param content
     * @param path
     * @return
     * @date 2016-06-06
     * @author dingshuang
     */
    public static String createWordFile(String fileName, String content, String path) {
        OutputStreamWriter os = null;
        FileOutputStream fos = null;
        try {
            if (fileName.indexOf(".doc") > -1) {
                fileName = fileName.substring(0, fileName.length() - 4);
            }
            File file = new File(path);
            //如果目录不存在就创建
            if (!(file.exists() && file.isDirectory())) {
                file.mkdirs();
            }
            fileName = path + "\\" + fileName + "-" + System.currentTimeMillis() + ".doc";
            //创建文件
            File targetFile = new File(fileName);
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }
            fos = new FileOutputStream(fileName);
            os = new OutputStreamWriter(fos, CHAR_SET);
            os.append(Html2DocUtil.addOfficeNameSpace(content)); //写入内容
            os.flush();
            return fileName;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                os.close();
                fos.close();
            } catch (Exception e) {
                return null;
            }
        }
    }


    /**
     * 添加office文档命名空间
     *
     * @param content
     * @return
     */
    private static String addOfficeNameSpace(String content) {
        StringBuffer spaceWarp = new StringBuffer();
        spaceWarp.append("<html xmlns:v=\"urn:schemas-microsoft-com:vml\"");
        spaceWarp.append("xmlns:o=\"urn:schemas-microsoft-com:office:office\"");
        spaceWarp.append("xmlns:w=\"urn:schemas-microsoft-com:office:word\"");
        spaceWarp.append("xmlns:m=\"http://schemas.microsoft.com/office/2004/12/omml\"");
        spaceWarp.append("xmlns=\"http://www.w3.org/TR/REC-html40\">");
        if (StringUtils.isNotBlank(content)) {
            spaceWarp.append(content);
        }
        spaceWarp.append("</html>");
        return spaceWarp.toString();
    }





    /**
     * 根据网页地址获取其某个元素的内容[html he style]
     *
     * @param url
     * @param nodeID
     * @param clearNodeIds
     * @return
     */
    public static String getContent(String url, String nodeID,String[] clearNodeIds ,String cssTag) {
        StringBuffer styleStr = new StringBuffer();
        StringBuffer contentStr = new StringBuffer();
        try {
            url = url.replaceAll("：",":");//将过滤器改变的符号改变回来
            log.info("url::" + url);
            Document doc = Jsoup.connect(url).get();
            Element element = doc.getElementById(nodeID);
            /*if(clearNodeIds != null ){
                for (String clearNodeId :clearNodeIds) {
                    Element clear_element = doc.getElementById(clearNodeId);
                    clear_element.remove();
                }
            }*/
            //拿到该元素的html内容,同时清理；
            contentStr.append(element.text());
            //获取该页面上所有的样式信息，注意加载顺序
            Elements linkElements = doc.getElementsByTag("link");
            Elements styleElements = doc.getElementsByTag("style");

            if(linkElements!= null){
                ListIterator<Element> iterator = linkElements.listIterator();
                String urllink = url.substring(0,22);
                while (iterator.hasNext()){
                    Element _element = iterator.next();
                    if(_element.attr("href").indexOf("css")>-1){
                        String link_href = urllink.substring(0,urllink.lastIndexOf("/")).concat("/"+_element.attr("href"));
                        styleStr.append(Jsoup.connect(link_href).get().body().html());
                    }
                }
            }
            if(styleElements!= null){
                ListIterator<Element> iterator = styleElements.listIterator();
                while (iterator.hasNext()){
                    Element _element = iterator.next();
                    styleStr.append(_element.html());
                }
            }
        } catch (IOException e) {
            log.info("url 不正确或者地址未找到");
        }
        StringBuffer content = new StringBuffer();
        //添加外加样式
        if(StringUtils.isNotBlank(cssTag)){
            styleStr.append(cssTag);
        }
        content.append("<head><style type=\"text/css\">"+styleStr+"</style></head>");
        content.append("<body>"+contentStr+"</body>");
        System.out.println("-----------------"+content.toString());

        return content.toString();
    }


    /**
     * Test
     *
     * @param str
     */
    public static void main(String[] str) {
        log.info("获取元素内容开始……");
        //String url = "http://127.0.0.1:7070/kongLei/%E4%BB%A3%E6%9F%A5%E4%BB%A3%E6%A3%80.html";
        //String url = "http://127.0.0.1:8080/81/kjcx/1311.jhtml";
        String url = "http://localhost:8081/app/lib_reader_detail.html";
        String content = Html2DocUtil.getContent(url, "center-box",new String[]{"subButton","retButton","downLoadLink"},"<style> .tableWrap{ width:733px; } </style>");
        log.info("获取元素内容结束……");
        log.info("content");
        log.info("生成world开始……");
        String filename = Html2DocUtil.createWordFile("消除" , content, "d:/test");
        log.info("filename :  "+filename);
        log.info("生成world结束……");
    }
}

