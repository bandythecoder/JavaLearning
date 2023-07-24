package OOOPS.Inheritence.Threads;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RejectExutionHandler
{

    public static void main(String[] args) throws InterruptedException
    {
        task();
    }

 static   void task() throws InterruptedException
    {
        ThreadPoolExecutor tp = new ThreadPoolExecutor(2,5,1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.DiscardPolicy());
                int i = 0;
        try
                {
                    for( i = 0; i < 50; i++)
                    {
                        tp.execute(() -> System.out.println(Thread.currentThread().getName() + " at work") );
                    }
                }
        catch (RejectedExecutionException rx)
        {
            System.out.println("Thread" + (i + 1) + "aborted");
        }
    }
}
