package org.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolAutoConfiguration {

    @Bean
    @ConditionalOnClass(ThreadPoolExecutor.class) //需要项目中存在ThreadPoolExecutor类。该类为JDK自带，所以一定成立
    public ThreadPoolExecutor MyThreadPool() {
        return new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
    }

}
