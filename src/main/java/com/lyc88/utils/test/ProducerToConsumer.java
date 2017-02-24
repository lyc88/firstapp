package com.lyc88.utils.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/5.
 */
public class ProducerToConsumer {
    List list = new ArrayList<>();

    public void product(){
        if(list.size()<1) {
            System.out.println("生产：" + 1);
            list.add(1);
        }
    }

    public void consume(){
        if(list.size()>0) {
            System.out.println("消费：" + list.get(0));
            list.remove(0);
        }
    }

    public static void main(String[] args) {
        ProducerToConsumer producerToConsumer = new ProducerToConsumer();
       // Producer producer = new Producer()

        new Thread(new Producer(producerToConsumer)).start();
        new Thread(new Consumer(producerToConsumer)).start();


    }
}

class Producer implements Runnable{

    private ProducerToConsumer producerToConsumer;

    public Producer(ProducerToConsumer producerToConsumer){
        this.producerToConsumer = producerToConsumer;
    }
    @Override
    public void run() {
        while (true){
            notifyAll();
            synchronized (this) {

                if(producerToConsumer.list.size()<1) {
                    producerToConsumer.product();
                }else {

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Consumer implements Runnable{

    private ProducerToConsumer producerToConsumer;

    public Consumer(ProducerToConsumer producerToConsumer){
        this.producerToConsumer = producerToConsumer;
    }
    @Override
    public void run() {
        while (true){
            notifyAll();
            synchronized (this) {

                if(producerToConsumer.list.size()>0) {
                    producerToConsumer.consume();
                }else {


                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}