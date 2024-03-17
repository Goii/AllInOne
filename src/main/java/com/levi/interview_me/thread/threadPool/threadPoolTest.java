package com.levi.interview_me.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Levi
 * @createTime: 2023年03月25日 21:07:13
 * @version: 1.0
 * @Description: 线程池：三大方法、七大参数、四种策略
 */
public class threadPoolTest {

    public static void main(String[] args) {

//        ExecutorService threadPool = Executors.newSingleThreadExecutor();// 单个线程
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);// 创建一个固定的线程池的大小
//        ExecutorService threadPool = Executors.newCachedThreadPool();// 单个线程
        //获取cpu 的核数
        int max = Runtime.getRuntime().availableProcessors();
        //创建线程池
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                max,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );


        try {
            for (int i = 1; i <= 5; i++) {
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + "：OK"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}

//public ThreadPoolExecutor(int corePoolSize,  //核心线程池大小
//                          int maximumPoolSize, //最大线程池的大小
//                          long keepAliveTime,  //超时时间，超过了就会释放线程
//                          TimeUnit unit, //超时单位
//                          BlockingQueue<Runnable> workQueue, //阻塞队列, 用来存储排队等待的线程
//                          ThreadFactory threadFactory, //线程工厂  创建线程的，我们一般不动
//                          RejectedExecutionHandler handler //拒绝策略，有四种
//                         ) {
//    if (corePoolSize < 0 ||
//        maximumPoolSize <= 0 ||
//        maximumPoolSize < corePoolSize ||
//        keepAliveTime < 0)
//        throw new IllegalArgumentException();
//    if (workQueue == null || threadFactory == null || handler == null)
//        throw new NullPointerException();
//    this.corePoolSize = corePoolSize;
//    this.maximumPoolSize = maximumPoolSize;
//    this.workQueue = workQueue;
//    this.keepAliveTime = unit.toNanos(keepAliveTime);
//    this.threadFactory = threadFactory;
//    this.handler = handler;
//}
