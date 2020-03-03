package Lesson5.Homework;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(exponential(2, 3));
        System.out.println(exponential(2, 10));
    }

    private static int exponential(int value, int exp) {
        if (exp == 0){
            return 1;
        } else if (exp == 1){
            return value;
        }
        return value * exponential(value, --exp);
    }
}
