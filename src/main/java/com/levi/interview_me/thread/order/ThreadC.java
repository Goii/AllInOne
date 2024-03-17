package com.levi.interview_me.thread.order;

/**
 * @Author: Levi
 * @createTime: 2023年10月12日 20:38:04
 * @version: 1.0
 * @Description:
 */
public class ThreadC extends Thread{

    ThreadB threadB;

    @Override
    public void run() {
        while (true) {
            synchronized (threadB) {
                synchronized (this) {
                    this.notify();
                    System.out.println("ThreadC call it's notify(); ");
                }

                try {
                    threadB.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ThreadB getThreadB() {
        return threadB;
    }

    public void setThreadB(ThreadB threadB) {
        this.threadB = threadB;
    }
}
