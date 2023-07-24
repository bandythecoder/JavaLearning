package OOOPS.Inheritence.Threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAndCallableTogether {

    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        try {
            CallableInterFace call = new CallableInterFace(5);
            ExecutorService es = Executors.newFixedThreadPool(100);
            Future<Integer> f = es.submit(call);

            while (!f.isDone()) {
                System.out.println("waiting for task to complete");
            }
            System.out.println(f.get());
        }
        catch (ExecutionException ex)
        {
            System.out.println(ex.getCause());;
        }
    }
}
