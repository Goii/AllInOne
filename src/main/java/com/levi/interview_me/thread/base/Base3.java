package com.levi.interview_me.thread.base;

/**
 * @Author: Levi
 * @createTime: 2023年03月25日 17:12:22
 * @version: 1.0
 * @Description: 继承Thread类实现方式三： 继承Thread类
 *
 * 缺点：单一继承
 */
public class Base3 {
    public static void main(String[] args) {
        MyThread3 thread3 =new MyThread3("A");
        thread3.start();
    }

}

class MyThread3 extends Thread{

    public MyThread3(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(currentThread().getName()+ " is Running !" );

    }
}