package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by khoa on 4/1/2016.
 */
public class ThreadingBasic {
    List<Integer> numberList = new ArrayList<>();

    private  void modifyList(){
        synchronized(numberList)
        {
            for(int i = 0 ; i < numberList.size(); i++)
            {
                if(numberList.get(i) %2 == 0)
                {
                    numberList.set(i,null);
                }
            }
            numberList.removeAll(Collections.singletonList(null));

            numberList.add(2);
            numberList.add(4);
            numberList.add(6);
            numberList.add(8);
            numberList.add(10);
        }
    }

    private  void printSum()
    {
        int num = 0 ;
        synchronized(numberList)
        {
            for(Integer i : numberList)
            {
                num += i;
            }
        }
        System.out.println("The sum is: " + num);
    }

    private static int testFinal(int n)
    {
        if(n%2 == 0)
        {
            try {
                return 42;
            }
            finally {
                try {
                    System.out.println("Prepare to pause");
                    Thread.sleep(2000);
                    System.out.println("testFinal end");
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        }
        return n;
    }
    public static void main(String[] args) {
        /*final ThreadingBasic tb = new ThreadingBasic();

        tb.numberList.add(2);
        tb.numberList.add(4);
        tb.numberList.add(6);
        tb.numberList.add(8);
        tb.numberList.add(10);
        tb.numberList.add(1);
        tb.numberList.add(3);
        tb.numberList.add(5);
        tb.numberList.add(7);
        tb.numberList.add(9);

        List<Thread> listThreads = new ArrayList<>();
        for(int i = 0 ; i <100; i++)
        {
            if(i %2 == 0 )
            {
                listThreads.add(new Thread(new Runnable() {
                    @Override
                    public void run() {
                       tb.modifyList();
                    }
                }));
            }
            else
            {
                listThreads.add(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        tb.printSum();
                    }
                }));
            }
        }

        for(Thread t: listThreads)
        {
            t.start();
        }*/

        System.out.println(testFinal(2));
    }
}
