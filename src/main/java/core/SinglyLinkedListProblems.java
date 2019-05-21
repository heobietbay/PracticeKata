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
        insertNth(oneTwoThree,-1,2);
        insertNth(oneTwoThree,5,5);
        insertNth(oneTwoThree,7,7);
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

    static Node<Integer> buildOneTwoThree(){
        return Node.createList(1,2,3);
    }

}
