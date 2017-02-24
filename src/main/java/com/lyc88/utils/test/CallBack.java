package com.lyc88.utils.test;

import java.util.Collections;

/**
 * Created by Administrator on 2017/2/4.
 * 动态方法调用
 */
public class CallBack {
    int a=1 ;
    static int b=1;

   public void add(){
       System.out.println("add ...");
   }

    public static void staticAdd(){
        System.out.println("staticAdd ...");
    }

}
class Children extends CallBack{
    int a ;
    static int b;

    public void add(){
        System.out.println("...add ...");
    }

    public static void staticAdd(){
        System.out.println("...staticAdd ...");
    }

    /*public static void main(String[] args) {
        CallBack children = new Children();
        children.add();
        children.staticAdd();
        System.out.println(children.a+"--"+children.b+"--");
    }*/
}

interface Call{
    int i=0;
    public void add();
    static void uptate(){
        System.out.println("hell");
    }
    //public static bb();
}
class Imp  implements Call,Comparable{

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Imp imp = (Imp) o;

        return i == imp.i;

    }

    @Override
    public int hashCode() {
        return i;
    }

    public int i = 1;

    @Override
    public String toString() {
        return "Imp{}";
    }

    @Override
    public void add() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Call call = new Imp();
        call.add();
        System.out.println(Call.i);
        Call.uptate();
        int x = -129;
        Integer i = x,z=x;
        int j = x;
        System.out.println(call);
        System.out.println(i);
        System.out.println(i==j);
        System.out.println(z==i);
        int j1 = i.compareTo(z);
        System.out.println(j1);
        //Collections.s
        Hello<Integer> h = new Hello<>();
        System.out.println(h.getT()+"--"+h.getHell(4.1));

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }


}
class Hello<T>{
    T i;
    public T getT(){
        return i;
    }

    public <E> Class getHell(E e){
        return e.getClass();
    }

}
