package Lesson4.Homework;

import java.util.Iterator;

public class SingleLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    public void insertHead(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertTail(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public T deleteHead() {
        T deletedValue = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        return deletedValue;
    }

    public T deleteTail() {
        T deletedValue = tail.value;
        Node<T> prev = findPrev(tail);
        tail = prev;
        if ( tail == null) {
            head = null;
        } else {
            prev.next = null;
        }
        return deletedValue;
    }

    public void insertAt(int index, T value) {
        if (index == 0) {
            insertHead(value);
            return;
        }

        Node<T> curr = head;
        Node<T> prev = null;
        for (int i = 0; i < index && curr != null; i++) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            insertTail(value);
            return;
        }

        Node<T> newNode = new Node<>(value);
        if (prev != null) {
            prev.next = newNode;
        }
        newNode.next = curr;
    }

    public T deleteAt(int index) {
        if (index == 0){
            return deleteHead();
        }

        Node<T> curr = head;
        Node<T> prev = null;
        for (int i = 0; i < index && curr != null; i++) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            return deleteTail();
        }

        T deletedValue = curr.value;
        if (prev != null) {
            prev.next = curr.next;
        }

        return deletedValue;
    }

    private Node<T> findPrev(Node<T> node) {
        Node<T> prev = head;
        while (prev != null && prev.next != node) {
            prev = prev.next;
        }
        return prev;
    }

    public void push(T value) {
        insertTail(value);
    }

    public T pop() {
        return deleteTail();
    }

    public T peek() {
        return tail.value;
    }

    public void enqueue(T value) {
        insertHead(value);
    }

    public T dequeue() {
        return deleteTail();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> curr = head;

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
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.insertHead(1);
        singleLinkedList.insertTail(2);
        singleLinkedList.insertHead(3);
        singleLinkedList.insertTail(4);
        singleLinkedList.insertHead(5);
        singleLinkedList.insertTail(6);
        singleLinkedList.insertHead(7);
        singleLinkedList.insertTail(8);
        singleLinkedList.insertTail(9);
        singleLinkedList.insertAt(0, 11);
        singleLinkedList.insertAt(4, 12);
        singleLinkedList.insertAt(12, 13);

        singleLinkedList.forEach(System.out::println);

        singleLinkedList.deleteHead();
        singleLinkedList.deleteTail();

        System.out.println("After delete head and tail");
        singleLinkedList.forEach(System.out::println);

        singleLinkedList.deleteHead();
        singleLinkedList.deleteTail();
        singleLinkedList.deleteHead();
        singleLinkedList.deleteTail();
        singleLinkedList.deleteHead();

        System.out.println("After delete all");
        singleLinkedList.forEach(System.out::println);
        System.out.println("________________");
        System.out.println("Homework:");
        singleLinkedList.deleteAt(1);
        System.out.println("Delete at index 1");
        singleLinkedList.forEach(System.out::println);
        singleLinkedList.deleteAt(2);
        System.out.println("Delete at index 2");
        singleLinkedList.forEach(System.out::println);

        System.out.println("Use push, pop, enqueue, dequeue:");
        singleLinkedList.deleteTail();
        singleLinkedList.deleteTail();
        singleLinkedList.deleteTail();
        singleLinkedList.enqueue(1);
        singleLinkedList.push(2);
        singleLinkedList.enqueue(3);
        singleLinkedList.push(4);
        singleLinkedList.enqueue(5);
        singleLinkedList.push(6);
        singleLinkedList.enqueue(7);
        singleLinkedList.push(8);
        singleLinkedList.push(9);
        singleLinkedList.insertAt(0, 11);
        singleLinkedList.insertAt(4, 12);
        singleLinkedList.insertAt(12, 13);

        singleLinkedList.forEach(System.out::println);

        singleLinkedList.deleteHead();
        singleLinkedList.pop();

        System.out.println("After delete head and tail");
        singleLinkedList.forEach(System.out::println);

        singleLinkedList.deleteHead();
        singleLinkedList.pop();
        singleLinkedList.deleteHead();
        singleLinkedList.pop();
        singleLinkedList.deleteHead();

        System.out.println("After delete all");
        singleLinkedList.forEach(System.out::println);
    }
}
