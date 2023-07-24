package OOOPS.Inheritence.Threads;

public class RunThreadClass {

    public static void main(String[] args) throws InterruptedException {
//        Thread th = new Thread1();
//        th.start();
//        Thread run = new Thread(new Thread2(),"thread2");
//        run.start();

        // lamda way

        Work w = new Work();
        Work w1 = new Work();
        Thread th = new Thread(() ->  w.print(), "t1");
        Thread th1 = new Thread(() ->  w1.modify(), "t2");
        th.start();
        th1.start();
        th.join();
        th1.join();


    }
}
