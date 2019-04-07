package normal;

import core.model.Node;

/**
 * This problem was asked by Microsoft.
   <pre>
 * Let's represent an integer in a linked list format by having each node represent a digit in the number.
 * The nodes make up the number in reversed order.
 *
 * For example, the following linked list:
 *
 * 1 -> 2 -> 3 -> 4 -> 5
 *
 * is the number 54321.
 *
 * Given two linked lists in this format, return their sum in the same linked list format.
 *
 * For example, given
 *
 * 9 -> 9
 *
 * 5 -> 2
 *
 * return 124 (99 + 25) as: 4 -> 2 -> 1
 * </pre>
 */
public class SumTwoLinkedList {
    public static void main(String[] args) {
        Node<Integer> headLst1 = buildInput(9,9);
        Node<Integer> headLst2 = buildInput(5,2);

        Node<Integer> headSum = solution(headLst1,headLst2);
        printList(headSum);

        System.out.println();

        headLst1 = buildInput(1,2,3);
        headLst2 = buildInput(0);
        headSum = solution(headLst1,headLst2);
        printList(headSum);

        System.out.println();
        headLst1 = buildInput(1,2,3);
        headLst2 = buildInput(9);
        headSum = solution(headLst1,headLst2);
        printList(headSum);

        System.out.println();
        headLst1 = buildInput(1,2,3,4,5);
        headLst2 = buildInput(5,4,3,2,1);
        headSum = solution(headLst1,headLst2);
        printList(headSum);
    }

    /**
     * This is not a difficult problem because of the REVERSED ORDER.
     * So the head already contains the last digit, we just need to apply addition step.
     * @param lst1  head of list 1
     * @param lst2  head of list 2
     * @return sum
     */
    public static Node<Integer> solution(Node<Integer> lst1, Node<Integer> lst2) {
        Node<Integer> sumHead = null;
        Node<Integer> res = null;
        int carry = 0;
        while(lst1 != null || lst2 != null)
        {
            Integer val1 = lst1 != null ? lst1.getVal() : 0;
            Integer val2 = lst2 != null ? lst2.getVal() : 0;

            int sum =  val1 + val2 + carry;
            if(sum >= 10)
            {
                carry = 1 ;
                sum = sum - 10;
            }
            else
            {
                carry = 0;
            }

            if(sumHead == null)
            {
                sumHead = new Node<>(sum,null);
                res = sumHead;
            }
            else
            {
                res.setNext(new Node<>(sum,null));
                res = res.getNext();
            }

            lst1 = lst1 != null ? lst1.getNext() : null;
            lst2 = lst2 != null ? lst2.getNext() : null;
        }
        // We need to check if we need to process the carry
        if(carry == 1)
        {
            res.setNext(new Node(carry,null));
        }
        return sumHead;
    }

    public static Node<Integer> buildInput(Integer... vals)
    {
        if(vals == null || vals.length < 1)
            throw new IllegalArgumentException("Invalid input");

        Node<Integer> head = new Node<>(vals[0],null);
        Node<Integer> runner = head;
        for(int i = 1; i < vals.length; i++)
        {
            Node<Integer> next = new Node(vals[i], null);
            runner.setNext(next);
            runner = next;
        }

        return head;
    }
    public static void printList(Node head){
        System.out.print( "" + head.getVal() + (head.getNext() == null ? "" : "->"));
        if(head.getNext() == null)
            return;
        printList(head.getNext());
    }
}
