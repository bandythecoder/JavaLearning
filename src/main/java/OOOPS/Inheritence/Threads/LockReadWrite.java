package OOOPS.Inheritence.Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockReadWrite {
    private List<Integer> list = new ArrayList<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private int count = 0;

    public void write()
    {
        lock.writeLock();
                try{
                    list.add(count++);
                }
                finally {
                    lock.writeLock().unlock();
                }

    }

    public void read()
    {
        lock.readLock();
        try {
            System.out.println(list.get(list.size() - 1));
        }
        finally
        {
            lock.readLock().unlock();
        }
    }
}
