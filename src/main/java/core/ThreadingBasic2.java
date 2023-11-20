package core;

import java.util.Random;

/**
 * Created by khoa on 4/1/2016.
 */
public class ThreadingBasic2 implements  Runnable {

    static Random generator = new Random();
    static Integer staticNumber = 0;
    static boolean done = false;
    public static void main(String[] args) throws InterruptedException {
        //testJoin();
        //TODO: explains why this is running forever
        new Thread(() -> {
            int count = 0;
            while(!done)
            {
                count++;
                System.out.println("...");
            }
            System.out.println("Count is: " + count);
        }).start();
        System.out.println(Thread.currentThread().getName() + " about to sleep");
        Thread.sleep(1000);
        System.out.println("Setting done to true");
        done = true;
    }

    private static void testJoin() throws InterruptedException {
        Thread t1 = new Thread(new ThreadingBasic2());
        t1.start();
        t1.join();

        Thread t2 = new Thread(new ThreadingBasic2());
        t2.start();
        t2.join();

        Thread t3 = new Thread(new ThreadingBasic2());
        t3.start();
        t3.join();

        Thread t4 = new Thread(new ThreadingBasic2());
        t4.start();
        t4.join();

        System.out.println(staticNumber);
    }

    @Override
    public void run() {
       staticNumber++;
    }
}
