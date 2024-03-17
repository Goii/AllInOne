package com.levi.interview_me.java8.lamada;

import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo extends RecursiveTask<Long> {

    private long start;
    private long end;
    //临界值
    private long temp = 1000L;

    public ForkJoinDemo(long start, long end){
        this.start = start;
        this.end = end;
    }

    /**
     * 计算方法
     * @return
     */
    @Override
    protected Long compute() {
        if ((end - start) < temp){
            Long sum = 0L;
            for (Long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        }else {
            // 使用ForkJoin 分而治之  计算
            // 1、计算平均值
            long middle = (start + end) / 2;
            // 拆分任务，把线程压入线程队列
            ForkJoinDemo forkJoinDemo1 = new ForkJoinDemo(start, middle);
            forkJoinDemo1.fork();
            ForkJoinDemo forkJoinDemo2 = new ForkJoinDemo(middle, end);
            forkJoinDemo2.fork();

            long taskSum = forkJoinDemo1.join() + forkJoinDemo2.join();
            return taskSum;
        }
    }
}
