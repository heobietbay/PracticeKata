package core.model;

import java.util.Objects;

public class Node<E> {

    public static <E> Node<E> createList(E... els)
    {
        Node<E> head = new Node<>(els[0],null);

        Node<E> tmp = head;
        for(int i = 1; i < els.length; i++)
        {
            tmp.setNext(new Node<E>(els[i],null));
            tmp = tmp.getNext();
        }

        return head;
    }
    public static <E> void printList(Node<E> list)
    {
        while(list != null)
        {
            System.out.print(list.getVal());
            list = list.getNext();
            if(list != null)
                System.out.print("->");
        }
    }

    public Node(E val, Node<E> next) {
        this.val = val;
        this.next = next;
    }

    /**
     * Getter.
     *
     * @return val
     */
    public E getVal() {
        return val;
    }

    /**
     * Setter.
     *
     * @param val val
     */
    public void setVal(E val) {
        this.val = val;
    }

    /**
     * Getter.
     *
     * @return next
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * Setter.
     *
     * @param next next
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(val, node.val) &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {

        return Objects.hash(val, next);
    }

    E val;
    Node<E> next;
}
