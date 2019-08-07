package com.demo.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * CPU intensive tasks and IO intensive tasks Thread pool config
 *
 * @author lhan111
 */
@Configuration
public class ThreadPoolConfig {
    // google ThreadFactory config
    /*final ThreadFactory threadFactory = new ThreadFactoryBuilder()
            .setNameFormat("cpu-async-task-name-%d")
            .setDaemon(true)
            .build();*/

    @Bean("cpuTaskExecutor")
    public Executor cpuTaskExecutor() {
        return new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                2 * Runtime.getRuntime().availableProcessors(),
                5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(256),
                r -> new Thread(r, "cpu-async-task-name-%d"), (r, executor) -> {
            // 打印日志，添加监控等，需要注意这里线程池的最大线程数，建议启动加上jvm指定heap memory等配置后使用压测工具测试，得到临界值
            System.out.println("cpuTaskExecutor is rejected!");
        });
    }

    @Bean("ioTaskExecutor")
    public Executor ioTaskExecutor() {
        return new ThreadPoolExecutor(2 * Runtime.getRuntime().availableProcessors(),
                3 * Runtime.getRuntime().availableProcessors(),
                5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(256),
                r -> new Thread(r, "io-async-task-name-%d"), (r, executor) -> {
            // 打印日志，添加监控等
            System.out.println("ioTaskExecutor is rejected!");
        });
    }
}