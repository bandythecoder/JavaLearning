package OOOPS.Inheritence.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WhatHappensifWeHaveFixedPoolSize {

    public static void main(String[] args)
    {
        ExecutorService es = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 1000; i++)
        {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("I am Arrived ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }


    }
}
