package OOOPS.Inheritence.Threads;

import java.util.concurrent.locks.ReentrantLock;

public class LockReentraant {

    private ReentrantLock lock = new ReentrantLock();
    int count = 0;
    public void increment()
    {
        lock.lock();
        try {
            count++;
        }
        finally
        {
            lock.unlock();
        }
    }

}
