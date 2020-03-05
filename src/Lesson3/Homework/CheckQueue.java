package Lesson3.Homework;

import Lesson3.Lesson.Queue;

public class CheckQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(100);

        System.out.println("Size: " + queue.size());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println("Size: " + queue.size());
    }
}
