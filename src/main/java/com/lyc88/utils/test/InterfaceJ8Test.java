package com.lyc88.utils.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/2/9.
 */
@FunctionalInterface
public interface InterfaceJ8Test {
   // String test();
    void test(String a);
    static void test01(){
        System.out.println("test01");
    }
    default void test02(){
        System.out.println("test02");
    }

    public static void main(String[] args) {

         /*new InterfaceJ8Test() {
           @Override
            public String test() {
                System.out.println("hello");
                return "hell";
            }

            @Override
            public void test(String a) {

            }
        }.test();*/
       /* new InterfaceJ8Test(()->(){
            System.out.println("hello");
        })*/
        String[] strings = {"a","b"};
        List list1 = Arrays.asList(strings);
        //list1.remove(0);

        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
       /* for (String temp : a) {
            if("2".equals(temp)){
                a.remove(temp);
            }
        }*/
        System.out.println(a);
        List list = new ArrayList<>();
        list.add("aa");
        list.forEach(n-> System.out.println(n));
        list.forEach(System.out::println);

    }

}
class Testj8{
    public void test(InterfaceJ8Test test){
        //test::test("gg");
        test.test("hell");
        System.out.println("hello j8");
    }

    public static void main(String[] args) {
        Testj8 testj8 = new Testj8();
        //InterfaceJ8Test interfaceJ8Test = new InterfaceJ8Test();
        testj8.test((p)->{
            System.out.println("ass"+p);
        });
        Runnable test01 = InterfaceJ8Test::test01;
        test01.run();
        /*testj8.((j)->{
            System.out::println(""+j);
        });*/
    }
}
