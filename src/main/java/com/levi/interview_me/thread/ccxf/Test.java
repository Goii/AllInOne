package com.levi.interview_me.thread.ccxf;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Levi
 * @createTime: 2023年09月18日 16:45:28
 * @version: 1.0
 * @Description: 生产者消费者测试类
 */
public class Test {

    public static void main(String[] args) {
        List list = new ArrayList();

        Producer producer = new Producer(list);
        Consumer consumer = new Consumer(list);

        Thread producerThread = new Thread(producer,"生产者线程");
        Thread consumerThread = new Thread(consumer,"消费者线程");

        producerThread.start();
        consumerThread.start();

    }
}
