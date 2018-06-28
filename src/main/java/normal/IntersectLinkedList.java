package normal;

import core.MySinglyLinkedList;
import core.model.Node;

import java.util.*;

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
        MySinglyLinkedList<Integer> lst1 = createLinkedList(8,0,12,22,23);
        MySinglyLinkedList<Integer> lst2 = createLinkedList(99,1,10,66,12,22,23);
        System.out.println(solution_KeepTrackOfVisitedNode(lst1,lst2));
    }

    /**
     * Using a map to keep track of visited nodes.
     * If we encounter a visited node -> thats the intersect point.
     * This does not seem to meet constant space requirement, since we need an extra map.
     * @param lst1
     * @param lst2
     * @return null or intersect point.
     */
    private static Integer solution_KeepTrackOfVisitedNode(MySinglyLinkedList<Integer> lst1, MySinglyLinkedList<Integer> lst2)
    {
        // Using set would have same effect/
        // Currently my implementation of Node.equals could lead to a lot of tracking -> not good performance.
        Map<Integer,Node<Integer>> visitedNodes = new HashMap<>();

        for ( Node<Integer> node : lst1.toNodeArray()) {
            visitedNodes.put(node.hashCode(),node);
        }

        for ( Node<Integer> node : lst2.toNodeArray()) {
            if(visitedNodes.containsKey(node.hashCode()))
                return node.getVal();
        }

        return null;
    }

    private static MySinglyLinkedList<Integer> createLinkedList(Integer... objs) {
        MySinglyLinkedList<Integer> linkedList = new MySinglyLinkedList<>();
        for(Integer i : objs)
        {
            linkedList.add(i);
        }
        return linkedList;
    }
}
