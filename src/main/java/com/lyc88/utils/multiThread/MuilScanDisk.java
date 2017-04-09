package com.lyc88.utils.multiThread;

import com.lyc88.services.DiskFilesService;
import com.lyc88.utils.DiskDetail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/2/26.
 */
public class MuilScanDisk {
    private  void listFiles(File file){
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        listFiles(file1);
                    } else if (file1.isFile()) {
                        System.out.println(DiskDetail.FileToDiskFile(file1));
                        //save(DiskDetail.FileToDiskFile(file1));
                    }
                }
            }
        }else if (file.isFile()) {
            System.out.println(DiskDetail.FileToDiskFile(file));
            //save(DiskDetail.FileToDiskFile(file));
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        MuilScanDisk muilScanDisk = new MuilScanDisk();
        ExecutorService executorService = Executors.newCachedThreadPool();
        File[] files = File.listRoots();
        for(File file:files){
           new Thread(muilScanDisk.new Test01(file)).start();
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

    class Test01 implements Runnable{

        private File file;
        public Test01(File file){
            this.file = file;
        }
        @Override
        public void run() {
            listFiles(file);
        }
    }
}

