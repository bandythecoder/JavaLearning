package OOOPS.Inheritence.Threads;

import java.util.concurrent.Callable;

public class CallableInterFace implements Callable<Integer> {
    private int n;

    public CallableInterFace(int n)
    {
        this.n = n;
    }
    @Override
    public Integer call() throws Exception {
        if(n == 0) return 0;
        int sum = 0;
        for(int i = 0; i < n ; i++)
        {
            sum += i;
        }
        return sum;
    }
}
