package leetcode.easy;

import core.model.Node;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
   <pre>
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 </pre>
 */
public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        Node<Integer> lst1 = createList(1,2,4);
        printList(lst1);

        System.out.println();

        Node<Integer> lst2 = createList(1,3,4);
        printList(lst2);

        System.out.println();

        Node<Integer> merge = solution(lst1,lst2);
        printList(merge);

        System.out.println();
        lst1 = createList(-9,3);
        printList(lst1);

        System.out.println();

         lst2 = createList(5,7);
        printList(lst2);

        System.out.println();

        merge = solution(lst1,lst2);
        printList(merge);
    }

    //TODO
    public static Node<Integer> solution(Node<Integer> lst1,Node<Integer> lst2)
    {
        Node<Integer> head = null;
        Node<Integer> runner = null;
        while(true)
        {
            Integer val1 = lst1 == null ? null : lst1.getVal();
            Integer val2 = lst2 == null ? null : lst2.getVal();

            if(val1 != null && val2 != null)
            {
                int cp = val1.compareTo(val2);
                if(cp <= 0)
                {
                    if(runner == null)
                    {
                        runner = new Node<>(val1,null);
                        head = runner;
                    }
                    else {
                        runner.setNext(new Node<>(val1,null));
                        runner = runner.getNext();
                    }
                    lst1 = lst1.getNext();
                }
                else {
                    if(runner == null)
                    {
                        runner = new Node<>(val2,null);
                        head = runner;
                    }
                    else {
                        runner.setNext(new Node<>(val2,null));
                        runner = runner.getNext();
                    }
                    lst2 = lst2.getNext();
                }
            }
            else if(val1 == null && val2 == null)
            {
                break;
            }
            else {
                if(val2 != null) {
                    if(runner == null)
                    {
                        runner = new Node<>(val2,null);
                        head = runner;
                    }
                    else{
                        runner.setNext(new Node<>(val2,null));
                        runner = runner.getNext();
                    }
                    lst2 = lst2.getNext();
                }
                if(val1 != null) {
                    if(runner == null)
                    {
                        runner = new Node<>(val1,null);
                        head = runner;
                    }
                    else{
                        runner.setNext(new Node<>(val1,null));
                        runner = runner.getNext();
                    }
                    lst1 = lst1.getNext();
                }
            }
        }
        return head;
    }

    static Node<Integer> createList(Integer... els)
    {
        return Node.createList(els);
    }
    static void printList(Node<Integer> list)
    {
        Node.printList(list);
    }
}
