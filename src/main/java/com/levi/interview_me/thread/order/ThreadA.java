package com.levi.interview_me.thread.order;

/**
 * @Author: Levi
 * @createTime: 2023年10月12日 20:37:19
 * @version: 1.0
 * @Description: 线程执行顺序A-B-C-A
 */
public class ThreadA extends Thread{

    ThreadC threadC;
    int times = 0;

    @Override
    public void run() {
        while (times < 2) {
            synchronized (threadC) {
                synchronized (this) {
                    this.notify();
                    System.out.println("ThreadA call it's notify(); ");
                }

                try {
                    threadC.wait();
                    times++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ThreadC getThreadC() {
        return threadC;
    }

    public void setThreadC(ThreadC threadC) {
        this.threadC = threadC;
    }

}
