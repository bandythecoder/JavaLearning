package OOOPS.Inheritence.Threads;

import java.util.concurrent.*;

public class WhatHappensIfThreadPoolSizeAndBlockingQueueIsFull {

    public static void main(String[] args)
    {
        ExecutorService es = new ThreadPoolExecutor(100,100,1, TimeUnit.MINUTES,new LinkedBlockingDeque<>(5));
        int n = 5;
        for(int i = 0; i < 1000; i++) {
            es.submit(() -> {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += j;
                }
                return sum;
            });
        }


    }
}
