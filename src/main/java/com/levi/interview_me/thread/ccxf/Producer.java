package com.levi.interview_me.thread.ccxf;

import java.util.List;

/**
 * @Author: Levi
 * @createTime: 2023年09月18日 16:42:21
 * @version: 1.0
 * @Description: 生产者
 */
public class Producer implements Runnable {

    List list;

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            synchronized (list){

                //生产几个后唤醒  消费者
                if (list.size()>3){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                list.add("产品");
                System.out.println(Thread.currentThread().getName()+ " 生产了一个"+ list.get(0));
                list.notify();
            }
        }
    }
}
