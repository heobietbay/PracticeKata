package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by khoa on 4/1/2016.
 */
public class ThreadingBasic2 implements  Runnable {

    static Random generator = new Random();
    static Integer staticNumber = 0;

    public static void main(String[] args) throws InterruptedException {
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
