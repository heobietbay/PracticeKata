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
    }

    //TODO
    public static Node<Integer> solution(Node<Integer> lst1,Node<Integer> lst2)
    {
        Node<Integer> head = lst1.getVal().compareTo(lst2.getVal()) < 0 ? lst1 : lst2;
        return null;
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
