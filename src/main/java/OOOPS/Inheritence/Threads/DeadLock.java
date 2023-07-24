package OOOPS.Inheritence.Threads;

public class DeadLock {
    static int count;
    static Object lock1 = new Object();
    static Object lock2 = new Object();


    public static void main(String[] args)
    {
        Thread t = new Thread(() -> increment());
        Thread t1 = new Thread(() -> decrement());
        t1.start();
        t.start();
    }

    public static void increment()
    {
        synchronized (lock1)
        {
            System.out.println("I am in lock1");

            synchronized (lock2)
            {
                for(int i = 0; i < 100; i++)
                count++;
            }
        }

    }

    public static void decrement()
    {
        synchronized (lock2)
        {
            System.out.println("I am in lock2");
            synchronized (lock1)
            {
                for(int i = 0; i < 100; i++)
                count--;
            }
        }
    }
}
