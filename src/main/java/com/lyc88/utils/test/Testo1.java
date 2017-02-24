package com.lyc88.utils.test;

/**
 * Created by Administrator on 2017/2/18.
 */
public class Testo1 {

    public static void main(String[] args) {
        Integer i = 2;
        Integer a = new Integer("187");
        Integer b = new Integer("278");
        System.out.println(a+"--"+b);
        String a1 = new String("aa");
        String b1 = new String("bb");
        System.out.println(a+"--"+b);
        swop(a,b);
        swopString(a1,b1);
        System.out.println(a+"--"+b);
    }

    private static void swop(Integer a, Integer b) {
        a = new Integer("567");
        Integer temp = a;
        a = b;
        b = temp;
    }

    private static void swopString(String a, String b) {
        String temp = a;
        a = b;
        b = temp;
        System.out.println(a+""+b);
    }

}
