package com.andrbezr2016.tasks3.mycollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;

    public MyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public void add(E element) {
        if (size == 0) {
            head = tail = new Node<>(element);
        } else {
            tail.nextNode = new Node<>(element, tail, null);
            tail = tail.nextNode;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index mustn't be negative or larger than size or equal size!");
        }
        if (index == size) {
            add(element);
        } else {
            if (index == 0) {
                head = new Node<>(element, null, head);
            } else {
                Node<E> currNode = head;
                for (int i = 1; i < index; i++) {
                    currNode = currNode.nextNode;
                }
                Node<E> newNode = new Node<>(element, currNode, currNode.nextNode);
                currNode.nextNode.prevNode = newNode;
                currNode.nextNode = newNode;
            }
            size++;
        }
    }

    @Override
    public void clear() {
        Node<E> currNode = head;
        while (currNode != null) {
            Node<E> temp = head.nextNode;
            currNode.element = null;
            currNode.prevNode = null;
            currNode.nextNode = null;
            currNode = temp;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index mustn't be negative or larger than size!");
        }
        Node<E> currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.nextNode;
        }
        return currNode.element;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        Node<E> currNode = head;
        while (currNode != null && !currNode.element.equals(element)) {
            currNode = currNode.nextNode;
            index++;
        }
        if (index == size) index = -1;
        return index;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index mustn't be negative or larger than size!");
        }
        E oldElement;
        if (index == size - 1) {
            Node<E> temp = tail.prevNode;
            tail.prevNode.nextNode = null;
            oldElement = tail.element;
            tail.element = null;
            tail.prevNode = null;
            tail = temp;
        } else if (index == 0) {
            Node<E> temp = head.nextNode;
            head.nextNode.prevNode = null;
            oldElement = head.element;
            head.element = null;
            head.nextNode = null;
            head = temp;
        } else {
            Node<E> currNode = head;
            for (int i = 0; i < index; i++) {
                currNode = currNode.nextNode;
            }
            currNode.prevNode.nextNode = currNode.nextNode;
            currNode.nextNode.prevNode = currNode.prevNode;
            oldElement = currNode.element;
            currNode.element = null;
            currNode.prevNode = null;
            currNode.nextNode = null;
        }
        size--;
        return oldElement;
    }

    @Override
    public E set(int index, E element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index mustn't be negative or larger than size!");
        }
        Node<E> currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.nextNode;
        }
        E oldElement = currNode.element;
        currNode.element = element;
        return oldElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] elements = new Object[size];
        Node<E> currNode = head;
        for (int i = 0; i < size; i++) {
            elements[i] = currNode.element;
            currNode = currNode.nextNode;
        }
        return elements;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray(E[] a) {
        if (a.length != size) {
            a = (E[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        Node<E> currNode = head;
        for (int i = 0; i < size; i++) {
            a[i] = currNode.element;
            currNode = currNode.nextNode;
        }
        return a;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> currNode = node;
                node = node.nextNode;
                return currNode.element;
            }
        };
    }

    private static class Node<E> {
        private E element;
        private Node<E> prevNode;
        private Node<E> nextNode;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node<E> prevNode, Node<E> nextNode) {
            this.element = element;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> currNode = head;
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                result.append(currNode.element).append(", ");
            } else {
                result.append(currNode.element);
            }
            currNode = currNode.nextNode;
        }
        return result.append("]").toString();
    }
}
