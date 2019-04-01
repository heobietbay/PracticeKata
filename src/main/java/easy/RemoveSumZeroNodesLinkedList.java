package easy;

import core.model.Node;

/**
 * This problem was asked by Amazon.
 *
 * <p>
 Given a linked list, remove all consecutive nodes that sum to zero. Print out the remaining nodes.
 <pre>
 For example, suppose you are given the input
 3 -> 4 -> -7 -> 5 -> -6 -> 6.
 In this case, you should first remove <font color='red'>3 -> 4 -> -7</font>, then <font color='red'>-6 -> 6</font>,
 leaving only <b>5</b>.
 </pre>
 * </p>
 */
public class RemoveSumZeroNodesLinkedList {

    public static void main(String[] args) {
        Node<Integer> inputList = buildInput(3 , 4 , -7 , 5 , -6 , 6);
        solution(inputList);
        solutionRecursive(inputList,null);
    }

    public static void solution(Node<Integer> head)
    {

    }

    public static void solutionRecursive(Node<Integer> head, Integer initialVal)
    {
        if(head == null) {
            return;
        }

        if(initialVal == null){
            initialVal = head.getVal();
            solutionRecursive(head.getNext(),initialVal);
        }
        else {
            initialVal =  initialVal + head.getVal();
            if(initialVal == 0)
            {
                System.out.println(head.getVal());
                // save the next node
                Node runner = head.getNext();
                // remove those node

                //continue
                solutionRecursive(runner,null);
            }
            else {
               solutionRecursive(head.getNext(),initialVal);
            }
        }
    }


    public static Node<Integer> buildInput(Integer... vals)
    {
        if(vals == null || vals.length < 2)
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
        System.out.println(head.getVal());
        if(head.getNext() == null)
            return;
        printList(head.getNext());
    }
}
