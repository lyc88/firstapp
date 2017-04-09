package com.lyc88.utils.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/3/19.
 * 排序算法
 *
 */
public class Sort1 {

    public static void main(String[] args) {
        int[] array = {1,3,2,4,39,6};
        int a;

      /*  for (int i:array)
        System.out.print(i+",");
        //sort1(array);
        sort2(array);
        System.out.println();
        for (int i:array)
        System.out.print(i+",");


        System.out.println(2>>2);*/
        List list = new ArrayList<>();

        for(int i = 0;i<11;i++){
            list.add(i);
        }

    }

    /**
     * 冒泡排序
     * @param a
     */
    public static void sort1(int[] a){
        int temp;
        //冒泡排序 需要次数，5个数只需要4 次就可以
        for (int i=0;i<a.length-1;i++){
            //开始冒泡 每次最大的沉到最下面
            for(int j=0;j<a.length-1;j++){
                if(a[j]<a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param a
     */
    public static void sort2(int[] a){
        int temp;
        int position;
        //选择的次数
        for(int i=0;i<a.length-1;i++){
            temp = a[i];
            position = i;
            for(int j=i+1;j<a.length;j++){
                //每次比较记住最大 的位置
                if(temp>a[j]){
                    position = j;
                    temp = a[j];
                }
            }
            if(position != i){
                a[position] = a[i];
                a[i] = temp;
            }
        }
    }
}
