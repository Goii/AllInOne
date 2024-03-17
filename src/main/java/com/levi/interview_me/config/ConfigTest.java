package com.levi.interview_me.config;

import com.levi.interview_me.thread.future.CompletableFutureTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Levi
 * @createTime: 2023年10月29日 09:23:39
 * @version: 1.0
 * @Description: SpringBoot 配置类
 */
@Configuration
public class ConfigTest {

    @Bean
    public CompletableFutureTest get(){
        return new CompletableFutureTest();
    }
}
