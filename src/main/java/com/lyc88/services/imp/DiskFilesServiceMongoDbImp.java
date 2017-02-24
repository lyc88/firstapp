package com.lyc88.services.imp;

import com.lyc88.beans.DiskFiles;
import com.lyc88.dao.DiskFilesDao;
import com.lyc88.services.DiskFilesService;
import com.lyc88.utils.DiskDetail;
import com.lyc88.utils.mongodb.MongoDBUtils;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/12.
 */
@Service("diskFilesServiceMongoDb")
public class DiskFilesServiceMongoDbImp implements DiskFilesService {
    private static Log log = LogFactory.getLog(DiskFilesServiceMongoDbImp.class);
    private static  MongoClient mongoClient = MongoDBUtils.getMongoClient();


    public void save(DiskFiles diskFiles) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mydisk");
        MongoCollection mongoCollection = mongoDatabase.getCollection("mydisk");
        Document document = new Document();
        document.append("fileSize",diskFiles.getFileSize()).append("fileName",diskFiles.getFileName())
                .append("fileType",diskFiles.getFileType()).append("filePath",diskFiles.getFilePath());
        mongoCollection.insertOne(document);

    }

    public void update(DiskFiles diskFiles) {

    }

    public void delete(DiskFiles diskFiles) {

    }

    public List<DiskFiles> getAll() {
        return null;
    }


    public DiskFiles get(Serializable uuid) {
        return null;
    }

    private  void listFiles(File file){
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        listFiles(file1);
                    } else if (file1.isFile()) {
                        save(DiskDetail.FileToDiskFile(file1));
                    }
                }
            }
        }else if (file.isFile()) {
            save(DiskDetail.FileToDiskFile(file));
        }
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DiskFilesService diskFilesService = (DiskFilesService) applicationContext.getBean("diskFilesServiceMongoDb");
        //DiskFilesDao diskFilesDao = (DiskFilesDao) applicationContext.getBean("diskFilesDao");

        long start = System.currentTimeMillis();
        if(log.isDebugEnabled()){
            log.debug("开始扫描");
        }
        diskFilesService.scanDisk();
        long end = System.currentTimeMillis();
        if(log.isDebugEnabled()){
            log.debug("用时:"+(end-start)/1000+"秒");
        }

        mongoClient.close();

    }

    /**
     * 扫描磁盘
     */
    public void scanDisk() {
        File[] files = File.listRoots();
        for(File file:files){
            listFiles(file);
        }
    }
}
