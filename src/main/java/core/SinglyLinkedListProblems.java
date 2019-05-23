package core;

import core.model.Node;

public class SinglyLinkedListProblems {

    public static void main(String[] args) {
        Node<Integer> oneTwoThree = buildOneTwoThree();
        System.out.println(countAppearance(oneTwoThree,1));

        Node<Integer> lst = Node.createList(1,2,2,3,3,3,3,4,4,4,4);
        System.out.println(countAppearance(lst,2));
        System.out.println(countAppearance(lst,3));
        System.out.println(countAppearance(lst,4));

        System.out.println(getNth(oneTwoThree,2));
        System.out.println(getNth(lst,2));
        System.out.println(getNth(lst,7));

        insertNth(oneTwoThree,4,3);
        insertNth(oneTwoThree,0,0);
        insertNth(oneTwoThree,5,5);
        insertNth(oneTwoThree,7,6);
        Node.printList(oneTwoThree);

        System.out.println();

        sortedInsert(oneTwoThree,new Node<>(-1,null));
        sortedInsert(oneTwoThree,new Node<>(2,null));
        sortedInsert(oneTwoThree,new Node<>(8,null));
        sortedInsert(oneTwoThree,new Node<>(6,null));
        Node.printList(oneTwoThree);

    }


    /**
     * Given a list and an int, return the number of times that int occurs in the list.
     * @param lst
     * @param searchFor
     * @return
     */
    static int countAppearance(Node<Integer> lst, int searchFor){
        int count = 0;
        if(lst != null){
            while(lst != null)
            {
                Integer el = lst.getVal();

                if(el != null && el.intValue() == searchFor)
                    count++;

                lst = lst.getNext();
            }
        }
        return count;
    }

    /**
     * Given a list and an index, return the data in the nth node of the list.
     * The nodes are numbered from 0.
     * Assert fails if the index is invalid (outside 0..lengh-1).
     * @param lst
     * @param idx
     * @return
     */
    static Integer getNth(Node<Integer> lst, int idx)
    {
        if(idx < 0)
            throw new IndexOutOfBoundsException();

        if(idx == 0)
            return lst.getVal();

        int count = 0;
        while(count != idx && lst != null)
        {
            lst = lst.getNext();
            count++;
        }
        if(count != idx) {
            throw new IndexOutOfBoundsException();
        }
        return lst.getVal();
    }
    /**
     * Insert a new node at any index within a list.
     * @param lst
     * @param idx
     * @param val
     */
    static void insertNth(Node<Integer> lst, int val, int idx) {
         if(lst == null)
             throw new IllegalArgumentException();
         if(idx < 0)
             throw new IndexOutOfBoundsException();

         int count = 0;
         Node<Integer> prev = lst;
         Node<Integer> runner = lst;
         while(count != idx && runner != null)
         {
             count++;
             prev = runner;
             runner = runner.getNext();
         }
         if(count != idx)
             throw new IndexOutOfBoundsException();

         if(runner == lst){
             Node<Integer> newNode = new Node<>(runner.getVal(),runner.getNext());
             runner.setVal(val);
             runner.setNext(newNode);
         }
         else {
             Node<Integer> newNode = new Node<>(val,prev.getNext());
             prev.setNext(newNode);
         }
    }

    /**
     * Given a list that is sorted in increasing order, and a single node, inserts the node into the correct sorted position in the list.
     * @param lst
     * @param newNode
     */
    static void sortedInsert(Node<Integer> lst, Node<Integer> newNode) {
        if(lst == null)
            throw new IllegalArgumentException();
        // case : newNode value is less than or equals to the head
        //  swap value of these 2, then the head will link to the new node
        if(newNode.getVal().compareTo(lst.getVal()) <= 0)
        {
            Integer tmp = newNode.getVal();
            newNode.setNext(lst.getNext());
            newNode.setVal(lst.getVal());
            lst.setNext(newNode);
            lst.setVal(tmp);
            return;
        }

        Node<Integer> prev = lst;
        Node<Integer> runner = lst;
        while(runner != null && runner.getVal().compareTo(newNode.getVal())<=0)
        {
            prev = runner;
            runner = runner.getNext();
        }

        // case newNode value is the largest value, newNode will be the tail
        if(runner == null){
            prev.setNext(newNode);
        }
        else {
            prev.setNext(newNode);
            newNode.setNext(runner);
        }
    }

    static Node<Integer> buildOneTwoThree(){
        return Node.createList(1,2,3);
    }

}
