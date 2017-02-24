package com.lyc88.utils.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Administrator on 2017/2/24.
 */
public class SetProxy {

    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建httpClient实例
        HttpGet httpGet = new HttpGet("https://www.taobao.com/"); // 创建httpget实例
        HttpHost proxy = new HttpHost("114.217.87.216", 8998);
        RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
        httpGet.setConfig(requestConfig);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        CloseableHttpResponse response = httpClient.execute(httpGet); // 执行http get请求
        HttpEntity entity = response.getEntity(); // 获取返回实体
        System.out.println("网页内容：" + EntityUtils.toString(entity, "utf-8")); // 获取网页内容
        response.close(); // response关闭
        httpClient.close(); // httpClient关闭
    }

    public static void test01() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建httpClient实例
        HttpGet httpGet = new HttpGet("http://central.maven.org/maven2/"); // 创建httpget实例
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(5000)
                .setSocketTimeout(5000)
                .build();
        httpGet.setConfig(config);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        CloseableHttpResponse response = httpClient.execute(httpGet); // 执行http get请求
        HttpEntity entity = response.getEntity(); // 获取返回实体
        System.out.println("网页内容：" + EntityUtils.toString(entity, "utf-8")); // 获取网页内容
        response.close(); // response关闭
        httpClient.close(); // httpClient关闭

    }

    public static void test02(){
        CloseableHttpClient httpclient = HttpClients.createDefault(); // 创建httpclient实例
        HttpGet httpget = new HttpGet("http://www.cnblogs.com/"); // 创建httpget实例

        CloseableHttpResponse response = null; // 执行get请求
        try {
            response = httpclient.execute(httpget);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity(); // 获取返回实体
        String content = null;
        try {
            content = EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            response.close(); // 关闭流和释放系统资源
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document doc = Jsoup.parse(content); // 解析网页 得到文档对象

        Element navTopElement = doc.getElementById("site_nav_top"); // 根据id来查询DOM
        String navTop = navTopElement.text(); // 返回元素的文本
        System.out.println("口号：" + navTop);

        Elements titleElements = doc.getElementsByTag("title"); // 根据tag名称来查询DOM
        Element titleElement = titleElements.get(0); // 获取第1个元素
        String title = titleElement.text(); // 返回元素的文本
        System.out.println("网页标题是：" + title);

        Elements postItemElements = doc.getElementsByClass("post_item "); // 根据样式名称来查询DOM
        for (Element e : postItemElements) {
            System.out.println(e.html());
            System.out.println("================");
        }

        Elements widthElements = doc.getElementsByAttribute("width"); // 根据属性名来查询DOM
        for (Element e : widthElements) {
            System.out.println(e.toString());
            System.out.println("================");
        }

        System.out.println("target-_blank");
        Elements targetElements = doc.getElementsByAttributeValue("target", "_blank");  // 根据属性名和属性值来查询DOM
        for (Element e : targetElements) {
            System.out.println(e.toString());
            System.out.println("================");
        }
    }

}
