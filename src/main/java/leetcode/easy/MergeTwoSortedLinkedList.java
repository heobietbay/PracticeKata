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

    /**
     * Use two pointer approach.
     * This require O(m+n) space, as we create a new linked list.
     * @param lst1
     * @param lst2
     * @return head of the new linked list.
     */
    public static Node<Integer> solution(Node<Integer> lst1,Node<Integer> lst2)
    {
        Node<Integer> head = null;
        Node<Integer> runner = null;
        while(true)
        {
            Integer el1 = lst1 == null ? null : lst1.getVal();
            Integer el2 = lst2 == null ? null : lst2.getVal();

            if(el1 != null && el2 != null)
            {
                int cp = el1.compareTo(el2);
                Integer val = cp <= 0 ? el1 : el2;
                if(runner == null)
                {
                    runner = new Node<>(val,null);
                    head = runner;
                }
                else {
                    runner.setNext(new Node<>(val,null));
                    runner = runner.getNext();
                }

                // move to next element
                lst1 = cp <= 0 ? lst1.getNext() : lst1;
                lst2 = cp > 0 ? lst2.getNext() : lst2;

            }
            else if(el1 == null && el2 == null)
            {
                break;
            }
            else {
                Integer val = el2 == null ? el1 : el2;
                if(runner == null)
                {
                    runner = new Node<>(val,null);
                    head = runner;
                }
                else{
                    runner.setNext(new Node<>(val,null));
                    runner = runner.getNext();
                }
                lst2 = el2 != null ? lst2.getNext() : lst2;
                lst1 = el1 != null ? lst1.getNext() : lst1;
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
