package com.levi.interview_me.thread.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Levi
 * @createTime: 2023年03月26日 19:35:44
 * @version: 1.0
 * @Description: 异步执行类
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 发起 一个 请求

//        System.out.println(System.currentTimeMillis());
//        System.out.println("---------------------");
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            //发起一个异步任务
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + ".....");
//        });
//        System.out.println(System.currentTimeMillis());
//        System.out.println("------------------------------");
//        //输出执行结果
//        System.out.println(future.get());  //获取执行结果

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
//                int i = 1 / 0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "1024";
        });

        System.out.println(completableFuture.whenComplete((t, u) -> {
            System.out.println("result= " + t);
            System.out.println("u= " + u);
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return "500";
        }).get());

    }
}
