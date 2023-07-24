package OOOPS.Inheritence.Threads;


import java.util.Random;

public class Work{
    int value;
    Random r = new Random();

    public void print()
    {
        int i = 1000000;
        while(i != 0)
        {
            if(value % 5 == 0)
            {
                if(value % 5 != 0)
                {
                    System.out.println(value);
                }
            }
        }
    }

    public void modify()
    {
        int i = 1000000;
        while (i != 0) {
            value = r.nextInt(1000);
            i--;
        }
    }


}
