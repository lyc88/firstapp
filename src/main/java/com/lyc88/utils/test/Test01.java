package com.lyc88.utils.test;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

/**
 * Created by Administrator on 2017/3/27.
 */
public class Test01 {
    public static void main(String[] args) throws Exception {
        List list = new ArrayList<>();
        HashMap map = new HashMap<>();
        map.put(null,null);
        File file = new File("D:\\1.jpg");

        InputStream in = new FileInputStream(file);
        System.out.println(in.available()+"=="+ file.length());
        int i1;
        while ((i1 = in.read()) != -1){
            System.out.println(in.available()+"=="+ file.length());
        }
        System.out.println(map);

        Hashtable hashTable = new Hashtable();
        hashTable.put(null,null);

        System.out.println(hashTable+""+hashTable.size());
        System.out.println(hashTable.get(null));


        for(int i= 1;i<=3;i++){
            list.add(i);
        }

        System.out.println(list);
        while (list.size()>1){
            for(int i=0,j=0;i<3;i++,j++){
                if(j == list.size()-1){
                    j = 0;
                }
                if(i==2){
                    System.out.println("remove :"+list.get(j)+"==:"+j);
                    list.remove(j);
                }
            }
        }

        System.out.println(list.get(0)+"---"+list.size());
    }
}
