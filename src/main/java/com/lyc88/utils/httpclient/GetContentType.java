package com.lyc88.utils.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Created by Administrator on 2017/2/24.
 * 一般网页是text/html当然有些是带编码的，

 比如请求www.tuicool.com：输出：

 Content-Type:text/html; charset=utf-8

 假如请求js文件，比如 http://www.open1111.com/static/js/jQuery.js
 运行输出：
 Content-Type:application/javascript

 假如请求的是文件，比如 http://central.maven.org/maven2/HTTPClient/HTTPClient/0.3-3/HTTPClient-0.3-3.jar
 运行输出：
 Content-Type:application/java-archive

 当然Content-Type还有一堆，那这东西对于我们爬虫有啥用的，我们再爬取网页的时候 ，可以通过

 Content-Type来提取我们需要爬取的网页或者是爬取的时候，需要过滤掉的一些网页；


 */
public class GetContentType {
    public static void main(String[] args) throws Exception{
        CloseableHttpClient httpClient= HttpClients.createDefault(); // 创建httpClient实例
        HttpGet httpGet=new HttpGet("http://www.java1234.com"); // 创建httpget实例
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0"); // 设置请求头消息User-Agent
        CloseableHttpResponse response=httpClient.execute(httpGet); // 执行http get请求
        HttpEntity entity=response.getEntity(); // 获取返回实体
        System.out.println("Content-Type:"+entity.getContentType().getValue());
        //System.out.println("网页内容："+EntityUtils.toString(entity, "utf-8")); // 获取网页内容
        response.close(); // response关闭
        httpClient.close(); // httpClient关闭
    }
}
