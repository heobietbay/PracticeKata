package core.model;

public class Node<E> {

    E val;
    Node next;

    public Node(E val, Node next) {
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
    public Node getNext() {
        return next;
    }

    /**
     * Setter.
     *
     * @param next next
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
