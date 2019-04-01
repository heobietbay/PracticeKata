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
        Node<Integer> headNode = buildInput(3 , 4 , -7 , 5 , -6 , 6);
        solutionRecursive(headNode,headNode,null);

        headNode = buildInput(3 , 1 , -10,2,4 , -2 , -6 , 8);
        solutionRecursive(headNode,headNode,null);
    }

    public static void solution(Node<Integer> head)
    {

    }

    /**
     * Using recursive.
     * Use a 'runner node' to proceed from that node til end.
     * Use a 'originalNode' to keep track from which we start.
     * <ol>
     *     <li>
     *         <pre>IF runnerNode is null and originalNode does not point to any node, meaning we have only have one number but
     *         without result -> stop there.</pre>
     *         <code>
     *             ELSE: Because we have element that link to originalNode, say orinalNodeNext, we continue from there.
     *         </code>
     *      </li>
     *      <li> We start with the HEAD
     *      </li>
     *      <li>
     *          We go from runnerNode til end, each time we sum the node.val.
     *          <code>
     *              Any point sum is 0, we KNOW that from originalNode to currentNode is the listNode we can remove.
     *          </code>
     *      </li>
     *      <li>This check every partition from a node til ends to make sure no listNode(that sums to 0) is missed</li>
     *
     * </ol>
     * @param runnerNode   the start point, we go from that til the end.
     * @param originalNode the original node, that we start from. Use this we can point out list node that sum to 0.
     * @param initialVal  the sum of node.val
     */
    public static void solutionRecursive(Node<Integer> runnerNode,Node<Integer> originalNode, Integer initialVal)
    {
        if(runnerNode == null) {
            if(originalNode.getNext() == null)
              return;
            else {
                solutionRecursive(originalNode.getNext(),originalNode,null);
                return;
            }
        }

        if(initialVal == null){
            initialVal = runnerNode.getVal();
            solutionRecursive(runnerNode.getNext(),runnerNode,initialVal);
        }
        else {
            initialVal =  initialVal + runnerNode.getVal();
            if(initialVal == 0)
            {
                System.out.println("[" + originalNode.getVal() + "," + runnerNode.getVal() + "]");

                // save the next node
                Node runner = runnerNode.getNext();

                //continue
                solutionRecursive(runner,originalNode,null);
            }
            else {
               solutionRecursive(runnerNode.getNext(),originalNode,initialVal);
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
