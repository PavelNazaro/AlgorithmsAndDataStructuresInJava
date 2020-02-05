package Lesson1;

public class Task2 {
    private static final int arr[] = {-55, 11, -23, -63, 54, 95, 106, 12, -40, 49, 0, 13, -9, 9};

    public static void main(String[] args) {
        int max1 = arr[0];
        int max2 = arr[0];

        for (int value : arr) {
            if (value > max1) {
                max1 = value;
            }
        }
        for (int value : arr) {
            if (value > max2 && value < max1) {
                max2 = value;
            }
        }

        System.out.println("Max1: " + max1);
        System.out.println("Max2: " + max2);
    }
}
