package com.lyc88.utils.rabbitMq.taotao;

public class TaotaoWeb {

    //具体执行业务的方法
    public void listen(String msg) {
        System.out.println("TaotaoWeb ： " + msg);
    }
}