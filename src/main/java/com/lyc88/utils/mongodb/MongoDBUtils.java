package com.lyc88.utils.mongodb;

import com.mongodb.MongoClient;

/**
 * Created by Administrator on 2017/2/12.
 */
public class MongoDBUtils {

    public static MongoClient getMongoClient(){
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        return mongoClient;
    }

    public static void colseMongoClient(MongoClient mongoClient){
        if(mongoClient != null){
            mongoClient.close();
        }
    }
}
