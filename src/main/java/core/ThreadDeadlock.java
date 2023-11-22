package core;

public class ThreadDeadlock {
    public static void main(String[] args){
        MyObject mo = new MyObject();
        Thread th1 = new Thread(() -> {
            try {
                mo.do1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        th1.start();
        Thread th2 = new Thread(() -> {
            try {
                mo.do2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        th2.start();
    }

    static class MyObject {
        Object key1;
        Object key2;

        public MyObject() {
            key1 = new Object();
            key2 = new Object();
        }

        public void do1() throws InterruptedException {
            synchronized (key1) {
                System.out.println("Holding key 1.....");
                Thread.sleep(1);
                synchronized (key2) {
                    System.out.println("Do 1 done.....");
                }
            }
        }
        public void do2() throws InterruptedException {
            synchronized (key2) {
                System.out.println("Holding key 2.....");
                Thread.sleep(1);
                synchronized (key1) {
                    System.out.println("Do 2 done....");
                }
            }
        }
    }
}
