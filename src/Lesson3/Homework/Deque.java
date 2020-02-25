package Lesson3.Homework;

public class Deque<T> {
    private T[] deque;
    private int front;
    private int rear;
    private int size;

    public Deque(int size) {
        this.deque = (T[]) new Object[size];
        this.front = 0;
        this.rear = deque.length - 1;
    }

    public void insertRight(T item){
        if (rear == deque.length - 1){
            rear = -1;
        }
        deque[++rear] = item;
        size++;
    }

    public void insertLeft(T item){
        if (front == 0){
            front = deque.length;
        }
        deque[--front] = item;
        size++;
    }

    public T removeRight(){
        T tmp = deque[rear--];
        if (rear == -1){
            rear = deque.length - 1;
        }
        size--;
        return tmp;
    }

    public T removeLeft(){
        T tmp = deque[front++];
        if (front == deque.length){
            front = 0;
        }
        size--;
        return tmp;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == deque.length;
    }

    public int size(){
        return size;
    }
}
