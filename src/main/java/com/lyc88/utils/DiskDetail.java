package com.lyc88.utils;

import com.lyc88.beans.DiskFiles;

import java.io.File;

/**
 * Created by Administrator on 2017/1/24.
 */
public class DiskDetail {

    private static int i = 1;
    public static void main(String[] args) throws InterruptedException {
       /* long start = System.currentTimeMillis();
        //File[] files = File.listRoots();
        File[] files = new File("F:\\迅雷下载\\03、版本控制SVN&GIT").listFiles();

        for (File file:files){
            listFiles(file);
        }
        long end = System.currentTimeMillis();

        System.out.println("用时"+(end-start)/1000);*/
        //File file = new File("F:\\迅雷is下载\\高效能人士的7个习惯.pdf");
        //System.out.println(file.getPath()+file.getAbsolutePath()+file.getName()+file.getAbsoluteFile());
        //System.out.println("文件数----"+i);
        long start = System.currentTimeMillis();
        File[] files = new File("F:\\迅雷下载\\03、版本控制SVN&GIT").listFiles();
        for (File file:files){
            listFiles(file);
            Thread thread = new Thread(new DiskDetail().new MuilThread(file));
            thread.start();
            thread.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("用时"+(end-start)/1000);
        System.out.println("文件数----"+i);
        //System.exit(0);

    }

    /**
     * 多线程扫描磁盘
     */
    class MuilThread implements Runnable{

        private File rootPath;

        public MuilThread(File rootPath) {
            this.rootPath = rootPath;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName()+"开始运行");
            listFiles(rootPath);
            System.out.println(Thread.currentThread().getName()+"结束运行");
        }
    }
    public static void listFiles(File file){
        //System.out.println(file.getName());
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                //System.out.println(files.length);

                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        listFiles(file1);
                    } else if (file1.isFile()) {

                        //System.out.println();
                        //i++;
                       // System.out.println("文件数----"+i+++file1.getName() + file1.length() + file1.getAbsolutePath());
                    }
                }
                //listFiles();
            }
        }else if (file.isFile()) {

            //System.out.println("文件数----"+i);
            //i++;
            //System.out.println("文件数----"+i+++file.getName() + file.length() + file.getAbsolutePath());
        }
    }

    /**
     * file 转换对象
     * @param file
     * @return
     */
    public static DiskFiles FileToDiskFile(File file){
        DiskFiles diskDetail = new DiskFiles();
        diskDetail.setFileName(file.getName());
        diskDetail.setFilePath(file.getAbsolutePath());
        diskDetail.setFileSize(String.valueOf(file.length()));
        int lastIndexOf = file.getAbsolutePath().lastIndexOf(".");
        if(lastIndexOf != -1)
        diskDetail.setFileType(file.getAbsolutePath().substring(lastIndexOf));
        return diskDetail;
    }
}
