package com.levi.interview_me.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: Levi
 * @createTime: 2023年03月25日 20:49:55
 * @version: 1.0
 * @Description: 阻塞队列
 * 方式	        抛出异常	    不会抛出异常，有返回值	阻塞，等待	    超时等待
 * 添加	        add()	    offer()	                put()	        offer(timeNum.timeUnit)
 * 移出	        remove()	poll()	                take()	        poll(timeNum,timeUnit)
 * 检测队首元素	element()   peek()
 */
public class QueueTest {
    public static void main(String[] args) {

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        queue.add("111");
        queue.add("2");
        queue.add("3");
//        Exception in thread "main" java.lang.IllegalStateException: Queue full
//        queue.add("4");

        queue.remove("111");

        boolean remove = queue.remove("4");

        System.out.println("queue.remove(\"4\") -> " + remove);
        queue.forEach(System.out::println);
    }
}
