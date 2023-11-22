package core.threading;

import java.util.concurrent.TimeUnit;

/**
 * Created by khoa on 3/22/2017.
 */
public class ThreadInterruptBasic {
    class Bartender implements Runnable {

        @Override
        public void run() {
            System.out.println("Bartender: My boss isn't in today; time for a quick snooze!");

            while (true) {
                if (Thread.interrupted()) {
                    System.out.println("Bartender: Zzz er erm, is someone waiting?");
                }
                try
                {
                    TimeUnit.SECONDS.sleep(5);
                }
                catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    class Customer implements Runnable {
        private Thread bartenderThread;
        private String name;
        private int waitTime;

        public Customer(Thread bartenderThread, String name, int waitTime)
        {
            this.bartenderThread = bartenderThread;
            this.name = name;
            this.waitTime = waitTime;
        }

        public void run()
        {
            System.out.println(name + ": Doesn't seem to be anyone around. I'll wait a moment");

            try
            {
                TimeUnit.SECONDS.sleep(waitTime);
            }
            catch (InterruptedException e)
            {
                // This can be ignored
            }

            System.out.println(name + ": Oh there's a bell! Can I get some service around here?");

            bartenderThread.interrupt();
        }
    }

    public static void main(String[] args) {
        ThreadInterruptBasic basic = new ThreadInterruptBasic();

        Bartender bartender = basic.new Bartender();
        Thread bartenderThread = new Thread(bartender, "Bartender");

        bartenderThread.start();

        // Not very robust, but should allow the bartender to get to sleep first
        try
        {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e)
        {
            // This can be ignored
        }

        int numCustomers = 5;

        for (int i=1; i<=numCustomers; i++) {
            String customerName = "Customer " + i;
            Customer customer = basic.new Customer(bartenderThread, customerName, (int) (Math.random() * 10));

            new Thread(customer, customerName).start();
        }
    }
}
