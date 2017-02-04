package com.lyc88.utils.test;

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

    public static void main(String[] args) {
        CallBack children = new Children();
        children.add();
        children.staticAdd();
        System.out.println(children.a+"--"+children.b+"--");
    }
}

interface Call{
    int i=0;
    public void add();
    static void uptate(){
        System.out.println("hell");
    }
    //public static bb();
}
class Imp implements Call{

    @Override
    public void add() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Call call = new Imp();
        call.add();
        System.out.println(Call.i);
        Call.uptate();
    }
}
