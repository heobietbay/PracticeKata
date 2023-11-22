package core.threading;

public class ThreadSynchronize {

    public static void main(String[] args) throws InterruptedException {
        // noSyncScenarios();
        synchScenario();
    }

    private static void synchScenario() throws InterruptedException {
        System.out.println("Last thread to finish will print out correct value");
        CounterSync counter = new CounterSync();
        Thread th1 = createIncreaseSyncCounterThread(counter);
        Thread th2 = createIncreaseSyncCounterThread(counter);
        Thread th3 = createIncreaseSyncCounterThread(counter);

        th1.start();
        th2.start();

        th1.join();

        th3.start();
        th3.join();

        th2.join();
    }

    static class CounterSync {
        private int count = 0;

        public int getCount() {
            return count;
        }
        public synchronized void incrementCount() {
            count++;
        }
    }

    private static Thread createIncreaseSyncCounterThread(CounterSync counterSync) {
        return new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                counterSync.incrementCount();
            }
            System.out.println(Thread.currentThread().getName() + ": " + counterSync.getCount());
        });
    }

    private static void noSyncScenarios() throws InterruptedException {
        System.out.println("Demo No Sync Join After All Threads Start");
        demoNoSyncJoinAfterAllThreadsStart();


        System.out.println("demoNoSyncSingleThreadStartThenJoinImmediately");
        demoNoSyncSingleThreadStartThenJoinImmediately();

        System.out.println("demoNoSyncThreadStartJoinRandomly");
        demoNoSyncThreadStartJoinRandomly();
    }

    /**
     * Each thread runs concurrently and read obsolete data.
     * @throws InterruptedException
     */
    static void demoNoSyncJoinAfterAllThreadsStart() throws InterruptedException {
        Counter counter = new Counter();
        Thread th1 = createIncreaseCounterThread(counter);
        Thread th2 = createIncreaseCounterThread(counter);
        Thread th3 = createIncreaseCounterThread(counter);

        th1.start();
        th2.start();
        th3.start();

        th1.join();
        th2.join();
        th3.join();
    }

    /**
     * This behaves as if one thread is running at a time, which is not what we wants.
     * @throws InterruptedException
     */
    static void demoNoSyncSingleThreadStartThenJoinImmediately() throws InterruptedException {
        Counter counter = new Counter();
        Thread th1 = createIncreaseCounterThread(counter);
        Thread th2 = createIncreaseCounterThread(counter);
        Thread th3 = createIncreaseCounterThread(counter);

        th1.start();
        th1.join();

        th2.start();
        th2.join();

        th3.start();
        th3.join();
    }

    static void demoNoSyncThreadStartJoinRandomly() throws InterruptedException {
        Counter counter = new Counter();
        Thread th1 = createIncreaseCounterThread(counter);
        Thread th2 = createIncreaseCounterThread(counter);
        Thread th3 = createIncreaseCounterThread(counter);

        th1.start();
        th2.start();

        th1.join();

        th3.start();
        th3.join();

        th2.join();
    }

    private static Thread createIncreaseCounterThread(Counter counter) {
        return new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                counter.incrementCount();
            }
            System.out.println(Thread.currentThread().getName() + ": " + counter.getCount());
        });
    }

    static class Counter {
        private int count = 0;

        public int getCount() {
            return count;
        }
        public void incrementCount() {
            count++;
        }
    }
}
