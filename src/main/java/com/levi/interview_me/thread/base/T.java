package com.levi.interview_me.thread.base;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Levi
 * @createTime: 2023年11月08日 15:01:39
 * @version: 1.0
 * @Description:
 */
public class T {
    public static void main(String[] args) throws InterruptedException, ExecutionException {


        ThreadFactory threadFactory = (Runnable r) -> {

            Thread thread = new Thread(r);
            thread.setUncaughtExceptionHandler((Thread t1, Throwable e) -> {
                System.out.println("线程工厂 exceptionHandler" + e.getMessage());
            });

            return thread;
        };

        ExecutorService executor = new ThreadPoolExecutor(1,
                1,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                threadFactory);
        final Future<?> submit = executor.submit(new task());


        Thread.sleep(1000);
        System.out.println(submit.get());
        System.out.println("==================为检验打印结果，1秒后执行execute方法");

        // execute 方法被线程工厂factory 的UncaughtExceptionHandler捕捉到异常
        executor.execute(new task());
    }
}

class task implements Runnable {
    @Override
    public void run() {
        System.out.println("进入了task方法！！！");
        int i = 1 / 0;
    }
}
