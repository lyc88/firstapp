package com.lyc88.utils;

import org.apache.solr.client.solrj.impl.HttpSolrClient;

/**
 * Created by Administrator on 2017/1/27.
 */
public class SolrServer {
    private static HttpSolrClient server = null;
    private static String url ="http://127.0.0.1:8080/solr/collections";

    public static HttpSolrClient getServer()
    {
        if(server == null){
            server = new HttpSolrClient(url);
            server.setDefaultMaxConnectionsPerHost(1000);
            server.setMaxTotalConnections(10000);
            server.setConnectionTimeout(60000);//设置连接超时时间（单位毫秒） 1000
            server.setSoTimeout(60000);//// 设置读数据超时时间(单位毫秒) 1000
            server.setFollowRedirects(false);//遵循从定向
            server.setAllowCompression(true);//允许压缩
        }
        return server;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(getServer());
    }
}
