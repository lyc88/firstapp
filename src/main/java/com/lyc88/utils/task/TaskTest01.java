package com.lyc88.utils.task;


import com.sun.jmx.snmp.tasks.Task;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/2/24.
 *
 * 总结：并不是main 函数执行完了 jvm 就退出了，如果有其他(非守护)用户线程 jvm 不会退出 如果不调System.exit(0)
 *  任务调度 后 只要jvm 没有退出 就会一直执行
 */
public class TaskTest01 extends TimerTask {

    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Override
    public void run() {
        System.out.println("hello"+ dateFormat.format(new Date()));
    }

    public static void main(String[] args) throws InterruptedException {
        //Thread thread = new Thread(new Test());
        //thread.setDaemon(true);
        //thread.start();
       /* ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new TaskTest01());

        executorService.shutdown();*/

       // Executors.newSingleThreadScheduledExecutor().execute(new Test());
        //Thread.sleep(100);
        //Thread.currentThread().join();
        ExecutorService executorService = Executors.newFixedThreadPool(1); // 只有一个固定
       // ExecutorService executorService = Executors.;//不限个数
        for(int i =0 ;i<3;i++){
            executorService.execute(new Test());
        }
        System.out.println(Thread.currentThread().getName()+"hello");

        return;
       // System.out.println("ggg");
        //System.exit(0);
    }

}
class Test implements Runnable{
    Timer timer=new Timer(true);

    @Override
    public void run() {
        //timer.
        // 每隔10秒钟执行任务
        System.out.println(Thread.currentThread().getName());


        /*for(int i=0;i<10;i++) {
            System.out.println(i);
        }*/

        /*try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //timer.schedule(new TaskTest01(),0,2*1000); //重复
        //timer.schedule(new TaskTest01(),new Date()); 一次
        //timer.scheduleAtFixedRate(new TaskTest01(),0,2*1000);
        System.out.println("begin");
    }
}
