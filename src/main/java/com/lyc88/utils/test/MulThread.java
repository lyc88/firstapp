package com.lyc88.utils.test;

/**
 * Created by Administrator on 2017/2/5.
 */
public class MulThread {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket);
        Thread thread2 = new Thread(ticket);
        Thread thread3 = new Thread(ticket);
        Thread thread4 = new Thread(ticket);
        thread1.start();thread2.start();thread3.start();thread4.start();
    }
}

class Ticket implements Runnable{
    int ticket = 100;

    @Override
    public void run() {
        while (true){
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + ticket--);
                } else {
                    break;
                }
            }
        }
    }
}