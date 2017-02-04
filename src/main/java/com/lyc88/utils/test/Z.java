package com.lyc88.utils.test;

/**
 * Created by Administrator on 2017/2/3.
 * 总结 1先静态 代码块 父类  后静态化子类 代码块
 * 2.先初始化父类的成员变量 在父类代码块 在父类构造器
 * 3.子类成员变量 代码块 构造器

 */


    class X {
        Y b = new Y();
        X() {
            System.out.println("X");
        }
        static{
            System.out.println("--x1--");
        }
        {
            System.out.println("--x--");
        }
    }

    class Y {
        Y() {
            System.out.println("Y");
        }
    }

    public class Z extends X {
        private final int FV = 1;
        static int SV = 2;
        Y y = new Y();
        static{
            System.out.println("--y1--");
            SV = 3;

        }
        {
            System.out.println("--y--"+FV);

        }
        Z() {
            System.out.println("Z"+FV);

        }

        public static void main(String[] args) {
           // new Z();
           // System.out.println(Z.SV);
            int i = (int)(Integer.MAX_VALUE+1);
            int j = Integer.MIN_VALUE-1;
            System.out.println(i+"--"+j);
            String a = "hello";
            String a1 = new String("hello");
            System.out.println(a == a1);
            System.out.println(a==a1.intern());
            aTob(8,3);
            aTob1(8,3);
            System.out.println(3>>1);
            char c = 'a'^'b'^'b';
            //String str = "aa"^"bb"^"bb";
            System.out.println(c);

            System.out.println("加密"+decode("abc",'2')+"--");
            System.out.println("解密"+decode(decode("abc",'2'),'2'));
            hex(12,15);
        }


        private static void aTob(int a,int b){
            a = a^b;
            b = a^b;
            a = a^b;
            System.out.println(" " +a +" "+b);
        }
        private static void aTob1(int a,int b){
            a = a+b;
            b = a-b;
            a = a-b;
            System.out.println(" " +a +" "+b);
        }

        /**
         * 加密 解密
         * @param str
         * @param c
         * @return
         * System.out.println("加密"+decode("abc",'2')+"--");
         * System.out.println("解密"+decode(decode("abc",'2'),'2'));
         */
        private  static String decode(String str ,char c){
            char[] chars = new char[str.toCharArray().length];
            for (int i=0;i<str.toCharArray().length;i++){
                chars[i] = (char) (c^(str.toCharArray()[i]));
            }
            return new String(chars);
        }

        private static String hex(int x,int y){
            int j = 0;
            System.out.println(j);
            return  Integer.toBinaryString(10);
            //while()

        }

    }

