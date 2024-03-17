package com.levi.interview_me.thread.rank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Levi
 * @createTime: 2023年09月18日 10:15:53
 * @version: 1.0
 * @Description: 线程按顺序执行
 *      1.join方式
 *      2.线程池提交顺序方式
 */
public class TestRank {

    public static void main(String[] args) {
        final Thread t1 = new Thread(()-> System.out.println("T1开始运行"));

        final Thread t2 = new Thread(()-> {
            try {
                t1.join();
                System.out.println("T2开始运行");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        final Thread t3 = new Thread(()-> {
            try {
                t2.join();
                System.out.println("T3开始运行");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t3.start();
        t2.start();
        t1.start();


        //==========线程池方式运行===========
        final Thread t4 = new Thread(()-> System.out.println("T4开始运行"));
        final Thread t5 = new Thread(()-> System.out.println("T5开始运行"));
        final Thread t6 = new Thread(()-> System.out.println("T6开始运行"));
        //按照线程池提交顺序执行。join 在线程池里不生效
        final ExecutorService threadPool = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
        threadPool.submit(t4);
        threadPool.submit(t6);
        threadPool.submit(t5);

        threadPool.shutdown();
    }
}
