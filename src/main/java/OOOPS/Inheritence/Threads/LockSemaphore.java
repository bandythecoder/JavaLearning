package OOOPS.Inheritence.Threads;

import java.util.concurrent.Semaphore;

public class LockSemaphore {
    private Semaphore s = new Semaphore(5);
    int x;

    public void increment()
    {
        boolean permit = s.tryAcquire();
        try {
            if (permit) {
                x++;
            }
        }
        finally {
          if(permit)  s.release();
        }

    }


}
