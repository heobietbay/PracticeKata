package core.model;

import java.util.Objects;

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
}
