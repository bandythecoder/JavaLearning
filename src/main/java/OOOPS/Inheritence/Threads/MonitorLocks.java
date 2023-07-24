package OOOPS.Inheritence.Threads;

public class MonitorLocks {

    int counter;

    public synchronized void increase() throws InterruptedException {
        this.wait();
        counter++;
        this.notify();

    }
}
