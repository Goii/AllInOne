package com.levi.interview_me.thread.order;

/**
 * @Author: Levi
 * @createTime: 2023年10月12日 20:37:55
 * @version: 1.0
 * @Description: 线程执行顺序A-B-C-A
 */
public class ThreadB extends Thread{

    ThreadA threadA;

    @Override
    public void run() {
        while (true) {
            synchronized (threadA) {
                synchronized (this) {
                    this.notify();
                    System.out.println("ThreadB call it's notify(); ");
                }

                try {
                    threadA.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ThreadA getThreadA() {
        return threadA;
    }

    public void setThreadA(ThreadA threadA) {
        this.threadA = threadA;
    }
}
