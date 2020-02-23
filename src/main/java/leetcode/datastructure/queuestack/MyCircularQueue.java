package leetcode.datastructure.queuestack;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 Design your implementation of the circular queue.
 The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle.
 It is also called "Ring Buffer".

 One of the benefits of the circular queue is that we can make use of the spaces in front of the queue.
 In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
 </pre>

 Your implementation should support following operations:
 <code>
  <ul>
       <li>MyCircularQueue(k): Constructor, set the size of the queue to be k.</li>
       <li>front: Get the front item from the queue. If the queue is empty, return -1.</li>
       <li>rear: Get the last item from the queue. If the queue is empty, return -1.</li>
       <li>enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.</li>
       <li>deQueue(): Delete an element from the circular queue. Return true if the operation is successful.</li>
       <li>isEmpty(): Checks whether the circular queue is empty or not.</li>
       <li>isFull(): Checks whether the circular queue is full or not.</li>
  </ul>
 </code>

 */
public class MyCircularQueue {
    //TODO: FIX
    public static void main(String[] args) {
       // test1();
        test2();
    }

    private static void test1() {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        circularQueue.enQueue(1);  // return true
        circularQueue.enQueue(2);  // return true
        circularQueue.enQueue(3);  // return true

        boolean add4 = circularQueue.enQueue(4);// return false, the queue is full
        System.out.println(add4);

        int rear = circularQueue.Rear();// return 3
        System.out.println(rear);

        boolean full = circularQueue.isFull();// return true
        System.out.println("isFull: " + full);

        circularQueue.deQueue();  // return true

        boolean enQueue4 = circularQueue.enQueue(4);// return true
        System.out.println(enQueue4);

        rear = circularQueue.Rear();  // return 4
        System.out.println(rear);
    }

    /**
     * Input: ["MyCircularQueue","enQueue","Rear","Front","deQueue","Front","deQueue","Front","enQueue","enQueue","enQueue","enQueue"]
     * [[3],[2],[],[],[],[],[],[],[4],[2],[2],[3]]
     *
     * Expected
     * [true,2,2,true,-1,false,-1,true,true,true,false]
     */
    private static void test2() {
        List<Object> outputs = new ArrayList<>();
        MyCircularQueue circularQueue = new MyCircularQueue(3);

        boolean enQueue2 = circularQueue.enQueue(2);// return true
        outputs.add(enQueue2);

        int rear = circularQueue.Rear();// return 2
        outputs.add(rear);

        int front = circularQueue.Front();// return 2
        outputs.add(front);

        boolean dequeue = circularQueue.deQueue();
        outputs.add(dequeue);

        front = circularQueue.Front();// return -1
        outputs.add(front);

        dequeue = circularQueue.deQueue();
        outputs.add(dequeue);

        front = circularQueue.Front();
        outputs.add(front);

        boolean enQueue4 = circularQueue.enQueue(4);// return true
        outputs.add(enQueue4);

        enQueue2 = circularQueue.enQueue(2);// return true
        outputs.add(enQueue2);

        enQueue2 = circularQueue.enQueue(2);// return true
        outputs.add(enQueue2);

        boolean enQueue3 = circularQueue.enQueue(3);
        outputs.add(enQueue3);

        System.out.println(outputs);
    }
    private static void test3() {
        List<Object> outputs = new ArrayList<>();
        MyCircularQueue circularQueue = new MyCircularQueue(6);

        boolean enQueue6 = circularQueue.enQueue(6);// return true
        outputs.add(enQueue6);

        int rear = circularQueue.Rear();// return 6
        outputs.add(rear);

        rear = circularQueue.Rear();// return 6
        outputs.add(rear);

        boolean dequeue = circularQueue.deQueue();
        outputs.add(dequeue);

        boolean enQueue5 = circularQueue.enQueue(5);// return true
        outputs.add(enQueue5);

        rear = circularQueue.Rear();// return 5
        outputs.add(rear);

        dequeue = circularQueue.deQueue();// return true
        outputs.add(dequeue);

        int front = circularQueue.Front(); // return -1
        outputs.add(front);

        dequeue = circularQueue.deQueue();
        outputs.add(dequeue);

        dequeue = circularQueue.deQueue();
        outputs.add(dequeue);

        dequeue = circularQueue.deQueue();
        outputs.add(dequeue);

        System.out.println(outputs);
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull())
            return false;
       /* if(data[tail] == null)  // If current tail has empty slot, put the element there
        {
            data[tail] = value;
        }
        else {
            // Reach end of array, however, first slots may be empty, move tail to the start.
            if(tail == data.length - 1)
            {
                tail = 0;
                data[tail] = value;
            }
            else {
                data[++tail] = value;
            }
        }*/
        if(tail == data.length - 1)
        {
            tail = -1;
        }
        head = head == -1 ? 0 : head;
        data[++tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty())
            return false;
        if(data[head] == null)
        {
            return false;
        }
        data[head] = null;
        head++;
       return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty())
            return -1;
        return data[head] == null? -1 : data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty())
            return -1;
       return data[tail] ;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head ==0 && tail==0 && data[0] == null;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail == data.length - 1 && data[tail] != null && head == 0) ;

    }


    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        System.out.println("How many: " + k);
        data = new Integer[k];
        head = -1;
        tail = -1;
    }

    // store elements
    private Integer[] data;
    // a pointer to indicate the head position
    private int head;

    // a pointer to indicate the tail position
    private int tail;
}
