package com.levi.interview_me.java8.lamada;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinTest {
    private static final long SUM = 20_0000_0000;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //test1();
        test2();
        test3();
    }

    public static void test1(){
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (int i = 0; i < SUM; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println("时间：" + (end - start));
        System.out.println("----------------------");
    }

    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, SUM);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long along = submit.get();

        System.out.println("计算结果"+along);
        long end = System.currentTimeMillis();
        System.out.println("时间：" + (end - start));
        System.out.println("-----------");
    }

    public static void test3(){
        long start = System.currentTimeMillis();

        long sum = LongStream.range(0L, SUM).parallel().reduce(0, Long::sum);
        System.out.println("计算结果"+sum);
        long end = System.currentTimeMillis();
        System.out.println("时间：" + (end - start));
        System.out.println("-----------");
    }

}
