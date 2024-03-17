package com.levi.interview_me.thread.tool;

import java.util.concurrent.Semaphore;

/**
 * @Author: Levi
 * @createTime: 2023年03月25日 17:38:38
 * @version: 1.0
 * @Description: 信号量
 * semaphore.acquire() 获得资源，如果资源已经使用完了，就等待资源释放后再进行使用！
 * semaphore.release()释放 ，会释放当前的信号量，然后唤醒等待的线程！
 *
 * 作用：
 *
 * 多个资源互斥时使用！并发限流，控制最大的线程数！
 */
public class SemaphoreTest {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName() + " 进入等待...");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 已经获取！");

                    System.out.println(Thread.currentThread().getName() + " 释放资源！");

                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            },"线程"+ String.valueOf(i)).start();

        }
    }
}
