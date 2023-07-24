package OOOPS.Inheritence.Threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private volatile AtomicInteger atomicInteger;

    public AtomicExample(int x)
    {
        atomicInteger = new AtomicInteger(x);
    }

    public void increment()
    {
        atomicInteger.getAndIncrement();
    }


}
