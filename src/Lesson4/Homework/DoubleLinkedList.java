package Lesson4.Homework;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    public DoubleLinkedList() {
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
    }

    public void insertTail(T value) {
        Node<T> newNode = new Node<>(value);
        if (head.value == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insertHead(T value) {
        Node<T> newNode = new Node<>(value);
        if (tail.value == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            head = newNode;
        }
    }

    public T deleteHead() {
        //TODO реализовать в качестве ДЗ
        return null;
    }

    public T deleteTail() {
        //TODO реализовать в качестве ДЗ
        return null;
    }

    //TODO реализовать итератор в качестве ДЗ

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            DoubleLinkedList.Node<T> curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
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

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.insertTail(3);
        doubleLinkedList.insertTail(4);
        doubleLinkedList.insertTail(5);
        doubleLinkedList.insertHead(1);
        doubleLinkedList.insertHead(2);
        doubleLinkedList.forEach(System.out::println);
    }
}
