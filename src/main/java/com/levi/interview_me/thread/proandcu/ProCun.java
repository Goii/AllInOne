package com.levi.interview_me.thread.proandcu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Levi
 * @createTime: 2023年11月05日 21:42:36
 * @version: 1.0
 * @Description: 生产者和消费者模型
 */
public class ProCun {
    final ReentrantLock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();
    public int num ;

    public void add () throws InterruptedException {
        try {
            lock.lock();
            //先写终止条件
            while (num !=0){
                condition.await();
            }

            //工作内容
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);

            //工作内容
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void sub() throws InterruptedException {
        try {
            lock.lock();
            //先写终止条件
            while (num ==0){
                condition.await();
            }
            //工作内容
            num--;

            System.out.println(Thread.currentThread().getName() + "\t" + num);

            //唤醒
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ProCun proCun = new ProCun();

        new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    proCun.add();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"add").start();

        new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    proCun.sub();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"sub").start();
    }
}
