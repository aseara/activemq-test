package com.aseara.activemq.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: aseara
 * Date: 2014/4/27
 * Time: 16:52
 */

@Component
public class HandlerScheduler {

    @Autowired
    private Handler handler;

    private final int fixedPoolSize = 2 * Runtime.getRuntime().availableProcessors();

    private ThreadPoolExecutor executor;

    @SuppressWarnings("unused")
    @PostConstruct
    private void init() {
        executor = new ThreadPoolExecutor(fixedPoolSize, fixedPoolSize, 60L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2000));
    }

    @SuppressWarnings("rawtypes")
    public void schedule(final String message) {

        System.out.println(
                String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                        executor.getPoolSize(),
                        executor.getCorePoolSize(),
                        executor.getActiveCount(),
                        executor.getCompletedTaskCount(),
                        executor.getTaskCount(),
                        executor.isShutdown(),
                        executor.isTerminated()));

        executor.execute(() -> {
            try {
                handler.handle(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
