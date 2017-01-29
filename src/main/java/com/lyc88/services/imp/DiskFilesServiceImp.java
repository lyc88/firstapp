package com.lyc88.services.imp;

import com.lyc88.beans.DiskFiles;
import com.lyc88.dao.DiskFilesDao;
import com.lyc88.services.DiskFilesService;
import com.lyc88.services.SubjectService;
import com.lyc88.utils.DiskDetail;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/26.
 */
@Service("diskFilesService")
public class DiskFilesServiceImp implements DiskFilesService {

    private static Log log = LogFactory.getLog(DiskFilesServiceImp.class);
    @Resource
    private DiskFilesDao diskFilesDao;

    public void save(DiskFiles diskFiles) {
       diskFilesDao.save(diskFiles);
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
                        diskFilesDao.save(DiskDetail.FileToDiskFile(file1));
                    }
                }
            }
        }else if (file.isFile()) {
            diskFilesDao.save(DiskDetail.FileToDiskFile(file));
        }
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DiskFilesService diskFilesService = (DiskFilesService) applicationContext.getBean("diskFilesService");
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
