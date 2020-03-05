package Lesson3.Lesson;

public class Stack<T> {
    int top;
    T[] stack;

    public Stack(int size) {
        this.stack = (T[]) new Object[size];
        this.top = 0;
    }

    public void push(T item){
        stack[top++] = item;
    }

    public T pop(){
        return stack[--top];
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public boolean isFull(){
        return top == stack.length;
    }
}
