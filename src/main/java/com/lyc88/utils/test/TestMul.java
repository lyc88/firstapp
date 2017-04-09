package com.lyc88.utils.test;

import java.util.List;
import java.util.Vector;

/**
 * Created by Administrator on 2017/3/31.
 */
public class TestMul {
    public static void main(String[] args) {
        List list = new Vector<>();
        Thread thread1 = new Thread(new Person01(list));
        Thread thread2 = new Thread(new Person02(list));
        Thread thread3 = new Thread(new Person03(list));
        Thread thread4 = new Thread(new Person04(list));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        boolean flag = true;
        while (flag){
            System.out.println(list.size());
            if(list.size() == 4){
                System.out.println("开始");
                flag = false;
            }else {
                System.out.println("等待");
            }

        }
    }
}
class Person01 implements Runnable{

    List list;
    public Person01(List list){
        this.list = list;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add("1");
    }
}
class Person02 implements Runnable{
    List list;
    public Person02(List list){
        this.list = list;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add("1");
    }
}
class Person03 implements Runnable{
    List list;
    public Person03(List list){
        this.list = list;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add("1");
    }
}
class Person04 implements Runnable{
    List list;
    public Person04(List list){
        this.list = list;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add("1");
    }
}
