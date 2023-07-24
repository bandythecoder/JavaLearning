package OOOPS.Inheritence.Threads;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletionService {

    public static void main(String[] args) throws Exception
    {
        completionServiceExample();
    }

    private static void completionServiceExample() throws ExecutionException, InterruptedException {
        AtomicInteger n = new AtomicInteger(100);

        Callable<Integer> callable = () -> n.getAndIncrement();

        ExecutorService ex = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<Integer> service = new ExecutorCompletionService<>(ex);
        for (int i = 0; i < 100; i++) {
            service.submit(callable);
        }

        int count = 100;

        while (count != 0)
        {
            Future<Integer> f = service.poll();;
            if(f != null)
            {
                System.out.println(f.get());
                count--;
            }
        }


    }


}
