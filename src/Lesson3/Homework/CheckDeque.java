package Lesson3.Homework;

public class CheckDeque {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>(100);

        System.out.println("Size: " + deque.size());

        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertRight(3);

        deque.insertLeft(5);
        deque.insertLeft(6);
        deque.insertLeft(7);

        System.out.println(deque.removeRight());
        System.out.println(deque.removeRight());

        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());

        deque.insertRight(8);
        deque.insertRight(9);

        deque.insertLeft(10);
        deque.insertLeft(11);

        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());

        System.out.println(deque.removeRight());
        System.out.println(deque.removeRight());
        System.out.println(deque.removeRight());

        System.out.println("Size: " + deque.size());
    }
}
