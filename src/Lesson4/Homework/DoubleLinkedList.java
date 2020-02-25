package Lesson4.Homework;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {

    private int n = 0;
    private Node<T> head;
    private Node<T> tail;

    public void insertTail(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()){
            head = tail = newNode;
        } else {
            Node<T> curr = tail;
            tail.next = newNode;
            tail = newNode;
            tail.prev = curr;
        }
        n++;
    }

    public void insertHead(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()){
            head = tail = newNode;
        } else {
            Node<T> curr = head;
            head.prev = newNode;
            head = newNode;
            head.next = curr;
        }
        n++;
    }

    public T deleteHead() {
        T deletedValue = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        n--;
        return deletedValue;
    }

    public T deleteTail() {
        T deletedValue = tail.value;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        }

        n--;
        return deletedValue;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            DoubleLinkedList.Node<T> curr = head;
            int i = n;

            @Override
            public boolean hasNext() {
//                return curr != null;
                return i-- > 0;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.insertTail(3);
        doubleLinkedList.insertTail(4);
        doubleLinkedList.insertTail(5);
        doubleLinkedList.insertHead(2);
        doubleLinkedList.insertHead(1);
        doubleLinkedList.forEach(System.out::println);
        System.out.println("Delete head: " + doubleLinkedList.deleteHead());
        doubleLinkedList.forEach(System.out::println);
        System.out.println("Delete tail: " + doubleLinkedList.deleteTail());
        doubleLinkedList.forEach(System.out::println);
        System.out.println("Delete tail: " + doubleLinkedList.deleteTail());
        doubleLinkedList.forEach(System.out::println);
    }
}
