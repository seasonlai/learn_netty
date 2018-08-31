package com.season.guide.chapter2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/8/31.
 */
public class TimeServerExecutePool {


    private ExecutorService executorService;


    public TimeServerExecutePool(int maxPoolSize, int queueSize) {

        executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize,
                120L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable runnable) {
        executorService.execute(runnable);
    }

}
