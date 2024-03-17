package com.levi.interview_me.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.collect.Sets;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Levi
 * @createTime: 2023年04月21日 10:50:19
 * @version: 1.0
 * @Description: Caffeine缓存
 */
public class CaffeineCache {


    public static void main(String[] args) {
        new Thread().run();
        Cache<String, Set<String>> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .maximumSize(10)
                .build();
        Set<String> key1 = cache.getIfPresent("key1");
        System.out.println(key1);
        Set<String> set = cache.get("key", key -> Sets.newHashSet("value1", "value2"));
        System.out.println(set);
    }

    private static void buildCache() {
        Cache<String, Set<String>> cache = Caffeine.newBuilder()
                //设置过期时间；向缓存中写入的数据会在1分钟之后过期
                .expireAfterWrite(1, TimeUnit.MINUTES)
                //设置最大值；最大可以放1条数据,当数据量超过最大值之后，则进行覆盖
                .maximumSize(1)
                .build();

        String cacheKey = "cacheKey";
        //从缓存中获取数据；如果数据不存在则通过第二个参数自动生成；如果生成失败则返回null
        Set<String> value0 = cache.get(cacheKey, key -> Sets.newHashSet("value1", "value2"));
        //从缓存中获取，如果不存在，则返回null
        Set<String> value1 = cache.getIfPresent(cacheKey);
        //向缓存中添加元素
        cache.put(cacheKey, Sets.newHashSet("value3", "value4"));
        //可通过asMap方法对产生的ConcurrentMap进行操作；
        cache.asMap().forEach((key, value) -> {
            if (key.equals(cacheKey)) {
                value.add("value5");
            }
        });
        //删除缓存
        cache.invalidate(cacheKey);
    }

}
