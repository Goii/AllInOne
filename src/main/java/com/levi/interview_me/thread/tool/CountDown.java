package com.levi.interview_me.thread.tool;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Levi
 * @createTime: 2023年03月25日 17:18:36
 * @version: 1.0
 * @Description: CountDownLatch
 *
 * await等待计数器归零，就唤醒，再继续向下运行。
 */
public class CountDown {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(6);
        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " is GO! ");
                count.countDown();

            }, String.valueOf(i) + "线程").start();

        }
        try {
            count.await();
            System.out.println(" ALL six is Ready");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
