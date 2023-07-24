package OOOPS.Inheritence.Threads;

public class ReentrantLockExample {
    public boolean isLock;
    synchronized void lock() throws InterruptedException {
        while(isLock)
        {
            wait();
        }
        isLock = true;
    }

    private synchronized void unLock() throws InterruptedException {
       notify();
       isLock = false;
    }


}
