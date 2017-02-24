package com.lyc88.utils.test;

import org.jsoup.Jsoup;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/5.
 * test 泛型 转型 ？super T  可以传入 是T父类 和T
 *               ？extends T 可以传入 继承 T 和 T
 */
public class Test {
    public static void main(String[] args) {
        List<?> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list = list1;
        list.add(null);

        A a = new A();
        List<Object> list6 = new ArrayList<>();
        List<? extends A> list2 = new ArrayList<>();
        List<? super A> list4 = new ArrayList<>();
        List<B> list3 = new ArrayList<>();
        List<A> list5 = new ArrayList<>();

        list2 = list5;
        list2 = list3;
        //list2 = list6;

        list4 = list5;
        list4 = list6;
        //list4 = list3;

        //list2.add(new A());
        //list2.add(new B());
        list2.add(null);
        list4.add(new A());
        list4.add(new B());
        list4.add(null);
        /*System.out.println(list4.size());
        for(Object obj:list4){
            System.out.println(obj);
        }*/
        Integer a1 = 10;
        Integer b = 20;
        method(a1,b);
        System.out.println(a1+"  "+b);
        //list2.add(2);
        System.out.println(Test.class.getResource("/"));

        System.out.println(Test.class.getResource(""));

        System.out.println(Test.class.getClassLoader().getResource("/"));
        System.out.println(Test.class.getClassLoader().getResource(""));

        System.out.println(Test.class.getPackage());


        System.out.println(Test.class.getName());

        Test test = new Test();
        try {
            System.out.println(test.getClass().getClassLoader().loadClass("com.lyc88.utils.test.Test").getPackage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void method(int a,int b){
        //Jsoup.connect("").
        Class clazz = Integer.class.getDeclaredClasses()[0];
        Field cache;
        try {
             cache = clazz.getDeclaredField("cache");
            cache.setAccessible(true);
            Integer[] array = (Integer[]) cache.get(clazz);
            array[138] = 100;
            array[148] = 200;
            for(Integer integer:array){
                //System.out.println(integer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       /* PrintStream myStream = new PrintStream(System.out) {
            @Override
            public void println(String x) {
                super.println(System.currentTimeMillis() + ": " + x);
            }
        };*/
           // System.out.print("hell;" + ++a);
        //return;
       // myStream.println("hello1");
    }

}

class A {

}
class B extends A{

}
