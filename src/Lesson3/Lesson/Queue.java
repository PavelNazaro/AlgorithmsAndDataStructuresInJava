package Lesson3.Lesson;

public class Queue<T> {
    private T[] queue;
    private int front;
    private int rear;
    private int size;

    public Queue(int size) {
        this.queue = (T[]) new Object[size];
        this.front = 0;
        this.rear = -1;
        this.size = size;
    }

    public void enqueue(T item){
        if (rear == queue.length - 1){
            rear = -1;
        }
        queue[++rear] = item;
        size++;
    }

    public T dequeue(){
        T tmp = queue[front++];
        if (front == queue.length){
            front = 0;
        }
        size--;
        return tmp;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == queue.length;
    }

    public int size(){
        return size;
    }
}
