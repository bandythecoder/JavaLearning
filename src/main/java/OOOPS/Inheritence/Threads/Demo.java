package OOOPS.Inheritence.Threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class Demo
{
    public static void main(String[] args) throws InterruptedException {
        LockReadWrite r = new LockReadWrite();
        Thread t = new Thread(() -> r.write());
        ExecutorService ex = Executors.newFixedThreadPool(10);
        IntStream.range(1,1000).forEach(i -> ex.submit(() -> {r.write();r.read();}));
        }

    }
