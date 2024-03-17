package com.levi.interview_me.thread.base;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Thread 创建方式二：继承Callable 重写call()call
 *      配合FutureTask 使用，可以获取到线程的执行结果。
 */
public class Base2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        FutureTask futureTask = new FutureTask(myThread2);
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            Object o = futureTask.get();

            System.out.println("用 FutureTask 获取线程结果:" + o.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class MyThread2 implements Callable{
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" is Running ! ");
        return "hello";
    }
}