package OOOPS.Inheritence.Threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HowToRetrieveValueFromCompletionService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(100);

        ExecutorCompletionService<Integer> ecs = new ExecutorCompletionService<>(es);

        for(int i = 0; i < 1000 ; i++)
        {
            ecs.submit(() -> 50);
        }

        int count = 1000;
        while(count > 0)
        {
            var value = ecs.poll();
            if(value!= null)
            {
                System.out.println(value.get());
                count--;
            }
        }

        es.shutdown();
    }
}
