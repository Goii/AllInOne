package com.levi.interview_me.thread.base;

public class Base {
    public static void main(String[] args) {
        //Runnable 实现类
        MyThread myThread = new MyThread();
        // Runnable 作为Thread的构造参数
        Thread thread = new Thread(myThread,"A");

        thread.start();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println("子线程："+Thread.currentThread().getName()+" is Running!");
    }
}