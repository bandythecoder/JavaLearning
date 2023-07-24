package OOOPS.Inheritence.Threads;

import java.util.stream.IntStream;

public class ThreadLocalExample {


    public static void main(String[] args) throws InterruptedException {
        Shared s = new Shared();
        Thread[] task = new Thread[100];
        for (int i = 0; i < 100; i++)
        {
            Thread th = new Thread(() -> IntStream.range(1, 100).forEach(x -> s.increment()));
            task[i] = th;
            th.start();


        }

        for(var th : task)
        {
            th.join();
        }

        System.out.println(s.count.get());
    }

    public static class Shared
    {
        ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);

        void increment()
        {
            count.set(count.get() +1);
        }
    }
}
