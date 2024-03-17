package com.levi.interview_me.thread.ccxf;

import java.util.List;

/**
 * @Author: Levi
 * @createTime: 2023年09月18日 16:36:53
 * @version: 1.0
 * @Description: 消费者
 */
public class Consumer implements Runnable {

    List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            synchronized (list){
                if(list.size() == 0){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                final Object remove = list.remove(0);
                System.out.println(Thread.currentThread().getName()+ " 消费了"+remove.toString());
                list.notify();
            }
        }
    }
}
