package com.levi.interview_me.thread.tool;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: Levi
 * @createTime: 2023年03月25日 17:52:05
 * @version: 1.0
 * @Description: 读写锁
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int j = i+1;
            new Thread(()->{
                myCache.put("线程"+j,random.nextInt(30) );
            },"线程"+String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            int j = i+1;
            new Thread(()->{
                myCache.get("线程"+j);
            },String.valueOf(i)).start();
        }

        System.out.println(myCache.toString());
    }
}


class MyCache {
    HashMap<String, Integer> cache = new HashMap<String, Integer>();
    ReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, Integer value) {
        lock.writeLock().lock();
        cache.put(key, value);
        System.out.println(Thread.currentThread().getName() + " put -->" + value);
        lock.writeLock().unlock();
    }

    public Integer get(String key) {
        Integer result = 0;
        lock.readLock().lock();
        result = cache.get(key);
        System.out.println(Thread.currentThread().getName() + " 获取 ==" + result);
        lock.readLock().unlock();
        return result;
    }

    @Override
    public String toString() {
        System.out.println("cache 结果展示：");
        if(cache.size()!=0){
            cache.forEach((k,v)->{
                System.out.println(k+" :" +v);
            });
        }
        return super.toString();
    }
}