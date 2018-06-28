package normal;

import core.MySinglyLinkedList;
import core.model.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * This problem was asked by Google.
 <p>
 *  Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
 *  <pre>
 *  For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
    In this example, assume nodes with the same value are the exact same node objects.
 </pre>
 *
 *  Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 </p>
 */
public class IntersectLinkedList {
    public static void main(String[] args) {
        MySinglyLinkedList<Integer> lst1 = createLinkedList(8,0,10,22,23);
        MySinglyLinkedList<Integer> lst2 = createLinkedList(99,1,8,66,10,22,23);
        System.out.println(solution(lst1,lst2));
    }

    private static Integer solution(MySinglyLinkedList<Integer> lst1, MySinglyLinkedList<Integer> lst2)
    {
        int sizeList1 = lst1.size();
        int sizeList2 = lst2.size();


        return null;
    }

    private static MySinglyLinkedList<Integer> createLinkedList(Integer... objs) {
        MySinglyLinkedList<Integer> linkedList = new MySinglyLinkedList<>();
        for(Integer i : objs)
        {
            if(!nodeMap.containsKey(i))
            {
                nodeMap.put(i, new Node<>(i,null));
            }
            linkedList.addNode(nodeMap.get(i));
        }
        return linkedList;
    }

    private static Map<Integer,Node<Integer>> nodeMap = new HashMap<>();
}
