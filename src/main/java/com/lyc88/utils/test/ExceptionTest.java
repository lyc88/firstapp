package com.lyc88.utils.test;

/**
 * Created by Administrator on 2017/2/16.
 */
public class ExceptionTest {

    public static String test01(){
        int i = 1;
        //try {
            i = i/0;
            return i+"";
        /*}catch (Exception e){
            e.printStackTrace();
            return i+"";
        }finally {
            //return "3";
        }*/

    }
    public static void main(String[] args) {
        System.out.println(test01());
    }
}
