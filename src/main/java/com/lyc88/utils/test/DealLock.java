package com.lyc88.utils.test;

/**
 * Created by Administrator on 2017/2/5.
 */
public class DealLock {
    static StringBuffer sb1 = new StringBuffer();
    static StringBuffer sb2 = new StringBuffer();

    public static void main(String[] args) {
        new Thread(new Runnable(){

            @Override
            public void run() {
                synchronized (sb1){
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sb1.append("sb1");
                    synchronized (sb2){
                        sb2.append("sb2");
                        System.out.println(sb1.toString()+sb2.toString());
                    }
                }
            }
        }).start();

        new Thread(new Runnable(){

            @Override
            public void run() {
                synchronized (sb2){
                    sb1.append("sb1");
                    synchronized (sb1){
                        sb2.append("sb2");
                        System.out.println(sb1.toString()+sb2.toString());
                    }
                }
            }
        }).start();


    }
}
