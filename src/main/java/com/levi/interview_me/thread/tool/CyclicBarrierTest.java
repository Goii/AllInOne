package com.levi.interview_me.thread.tool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: Levi
 * @createTime: 2023年03月25日 17:29:14
 * @version: 1.0
 * @Description: CyclicBarrier
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("集齐7张彩券兑换奖励！");
        });

        for (int i = 0; i < 9; i++) {
            int j = i+1;
            new Thread(()->{
                System.out.println("线程 "+Thread.currentThread().getName()+" 收集第"+ j + "张奖券");

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(j)).start();
        }
        cyclicBarrier.reset();
    }
}
