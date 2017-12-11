package core.model;

public class Node {
    Integer val;
    Node next;

    public Node() {
    }

    public Node(Integer val, Node next) {
        this.val = val;
        this.next = next;
    }

    /**
     * Getter.
     *
     * @return val
     */
    public Integer getVal() {
        return val;
    }

    /**
     * Setter.
     *
     * @param val val
     */
    public void setVal(Integer val) {
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
