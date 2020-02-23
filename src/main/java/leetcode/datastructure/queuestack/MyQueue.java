package leetcode.datastructure.queuestack;// "static void main" must be defined in a public class.

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        if (q.isEmpty() == false) {
            System.out.println(q.front());
        }

        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.front());
        }

        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.front());
        }
    }

    /** Insert an element into the queue. Return true if the operation is successful. */
    public boolean enQueue(int x) {
        data.add(x);
        return true;
    };
    /** Delete an element from the queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        start++;
        return true;
    }
    /** Get the front item from the queue. */
    public int front() {
        return data.get(start);
    }
    /** Checks whether the queue is empty or not. */
    public boolean isEmpty() {
        return start >= data.size();
    }

    public MyQueue() {
        data = new ArrayList<Integer>();
        start = 0;
    }

    // store elements
    private List<Integer> data;
    // a pointer to indicate the start position
    private int start;
}