package core;

import core.model.Node;

import java.util.*;

public class MySinglyLinkedList<E> implements List<E> {

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = head; x != null; x = x.getNext())
            result[i++] = x.getVal();
        return result;
    }
    public Node<E>[] toNodeArray() {
        Node<E>[] result = new Node[size];
        int i = 0;
        for (Node<E> x = head; x != null; x = x.getNext())
            result[i++] = x;
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        //TODO
        return null;
    }

    @Override
    public boolean add(E e) {
        if(head == null)
        {
           head = new Node<>(e,null);
        }
        else
        {
            // get last
            Node<E> lastNode = getNodeAtIndex(size - 1);
            lastNode.setNext(new Node<>(e,null));
        }
        size++;
        return true;
    }
    public boolean addNode(Node<E> node) {
        if(head == null)
        {
            head = node;
        }
        else
        {
            // get last
            Node<E> lastNode = getNodeAtIndex(size - 1);
            lastNode.setNext(node);
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node runNode = head;
        int startIdx = 0;
        while(startIdx < size && runNode != null)
        {
            Node nextNode = runNode.getNext();
            if(nodeContainsValue(o, nextNode))
            {
                runNode.setNext(nextNode.getNext());
                nextNode.setNext(null);
                nextNode.setVal(null);
                size--;
            }
            else if (nodeContainsValue(o,runNode))
            {
                if(runNode != head )
                {
                    runNode.setNext(null);
                    runNode.setVal(null);
                }
                else
                {
                    runNode.setVal(null);
                    head = head.getNext();
                }
                size--;
            }
            runNode = runNode.getNext();
            startIdx++;
        }
        return true;
    }

    private static boolean nodeContainsValue(Object val, Node node) {
        return node != null && ((node.getVal() == null && val == null) || val.equals( node.getVal()));
    }


    @Override
    public boolean containsAll(Collection<?> collection) {
        assert collection != null && !collection.isEmpty();
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        assert collection != null && !collection.isEmpty();
        //TODO:
        size += collection.size();
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        assert collection != null && !collection.isEmpty();
        //TODO:
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        assert collection != null && !collection.isEmpty();
        //TODO:
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        assert collection != null && !collection.isEmpty();
        //TODO:
        return false;
    }

    @Override
    public void clear() {
        //TODO:
    }

    public Node<E> getNode(int idx)
    {
        checkSize(idx);
        return getNodeAtIndex(idx);
    }

    @Override
    public E get(int index) {
        checkSize(index);
        Node<E> node = getNodeAtIndex(index);
        return node.getVal();
    }

    @Override
    public E set(int index, E element) {
        checkSize(index);
        Node<E> node = getNodeAtIndex(index);
        E oldVal = node.getVal();
        node.setVal(element);
        return oldVal;
    }

    @Override
    public void add(int index, E element) {
        checkSize(index);
        Node<E> node = getNodeAtIndex(index);
        Node<E> newNode = new Node<>(element,node.getNext());
        node.setNext(newNode);
        size++;
    }

    @Override
    public E remove(int index) {
        checkSize(index);
        if(index == 0)
        {
            if(size == 1)
            {
                head.setVal(null);
                head = null;
            }
            else
            {
                Node newHead = head.getNext();
                head.setNext(null);
                head.setVal(null);
                head = newHead;
            }
        }
        else
        {
            Node<E> nodeToRemove = getNodeAtIndex(index);
            Node<E> previousNode = getNodeAtIndex(index - 1);
            // update link
            previousNode.setNext(nodeToRemove.getNext());

            // unlink node to remove
            nodeToRemove.setNext(null);
            nodeToRemove.setVal(null);
        }
        size--;
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int foundIdx = -1;
        int start = 0;
        Node runNode = head;
        Node foundNode = null;
        while(start < size)
        {
            if( (runNode.getVal() == null && o == null ) || (runNode.getVal().equals(o)) )
            {
                foundNode = runNode;
                break;
            }
            start++;
            runNode = runNode.getNext();
        }
        if(foundNode != null)
        {
            foundIdx = start;
        }
        return foundIdx;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private Node<E> getNodeAtIndex(int index) {
        int startIdx  = 0;
        Node<E> startNode = head;
        while(startIdx < index)
        {
            startNode = startNode.getNext();
            startIdx++;
        }
        return startNode;
    }

    private void checkSize(int index) {
        if (index < 0 || index > size )
            throw new IndexOutOfBoundsException();
    }

    @Override
    protected Object clone() {
        MySinglyLinkedList<E> clone = new MySinglyLinkedList<>();
        for (Node<E> x = head; x != null; x = x.getNext())
        {
           clone.add(x.getVal());
        }
        return clone;
    }

    private transient int size = 0;
    private Node<E> head;


    public static void main(String[] args) {
        MySinglyLinkedList<Integer> lst = new MySinglyLinkedList<>();
        lst.add(3);
        lst.add(4);
        lst.add(1);
        lst.add(2);

        if(lst.size() != 4)
        {
            throw new RuntimeException("List size() not working as expected.");
        }

        String tmp = Arrays.toString(lst.toArray());
        if(!tmp.equals("[3, 4, 1, 2]"))
        {
           throw new RuntimeException("List toArray() not working as expected.");
        }

        Integer first = lst.get(0);
        if(first.intValue() != 3)
        {
            throw new RuntimeException("List get() not working as expected.");
        }

        testRemoveObject(lst);
        testRemoveElementByIndex(lst);
    }

    private static void testRemoveElementByIndex(MySinglyLinkedList<Integer> lst) {
        MySinglyLinkedList<Integer> cloned = (MySinglyLinkedList<Integer>) lst.clone();

        cloned.remove(2);
        Integer last = cloned.get(cloned.size() - 1);
        if(last.intValue() != 2)
        {
            throw new RuntimeException("List remove(int) not working as expected.");
        }
        cloned.remove(0);
        last = cloned.get(0);
        if(last.intValue() != 4)
        {
            throw new RuntimeException("List remove(int) not working as expected.");
        }
    }

    private static void testRemoveObject(MySinglyLinkedList<Integer> lst) {
        MySinglyLinkedList<Integer> cloned = (MySinglyLinkedList<Integer>) lst.clone();
        Integer last = cloned.get(cloned.size() - 1);
        if(last.intValue() != 2)
        {
            throw new RuntimeException("List get() not working as expected.");
        }

        cloned.remove(Integer.valueOf(2));
        last = cloned.get(cloned.size() - 1);
        if(last.intValue() != 1)
        {
            throw new RuntimeException("List remove() not working as expected.");
        }
        cloned.remove(Integer.valueOf(3));
        last = cloned.get(0);
        if(last.intValue() != 4)
        {
            throw new RuntimeException("List remove() not working as expected.");
        }
        cloned.remove(Integer.valueOf(4));
        last = cloned.get(0);
        if(last.intValue() != 1)
        {
            throw new RuntimeException("List remove() not working as expected.");
        }
    }
}
