package OOOPS.Inheritence.Threads;

import java.util.concurrent.*;

public class JavaExecutors {

    public static void main(String[] args) throws InterruptedException {
        taskusingBlockingQueue();
    }
    public static void taskusingSyncroniousQueue() throws InterruptedException {
        int i = 0;
        ThreadPoolExecutor ex = new ThreadPoolExecutor(1,5,1, TimeUnit.MINUTES,new SynchronousQueue<>());
       try {
           for (i = 0; i < 50; i++) {

               ex.execute(() -> System.out.println("Task " + " working."));
           }
       }
       catch (RejectedExecutionException re)
       {
           System.out.println("Task " + (i + 1) + " rejected.");
       }
       finally {
           ex.shutdown();
           ex.awaitTermination(1, TimeUnit.HOURS);
       }
    }

    public static void taskusingBlockingQueue() throws InterruptedException {
        int i = 0;
        ThreadPoolExecutor ex = new ThreadPoolExecutor(1,5,1, TimeUnit.MINUTES,new LinkedBlockingDeque<>());
        try {
            for (i = 0; i < 50; i++) {

                ex.execute(() -> System.out.println("Task " + " working."));
            }
        }
        catch (RejectedExecutionException re)
        {
            System.out.println("Task " + (i + 1) + " rejected.");
        }
        finally {
            ex.shutdown();
            ex.awaitTermination(1, TimeUnit.HOURS);
        }
    }
}
