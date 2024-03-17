package com.levi.interview_me.thread.order;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Levi
 * @createTime: 2023年10月12日 20:41:57
 * @version: 1.0
 * @Description: 测试线程执行顺序
 */
public class Test {

    public static void main(String[] args) {

//        ThreadA threadA = new ThreadA();
//        ThreadB threadB = new ThreadB();
//        ThreadC threadC = new ThreadC();
//
//        threadA.setThreadC(threadC);
//        threadB.setThreadA(threadA);
//        threadC.setThreadB(threadB);
//
//        threadA.start();
//        threadB.start();
//        threadC.start();
        final ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.isTerminated();
        executorService.shutdown();
    }
}
