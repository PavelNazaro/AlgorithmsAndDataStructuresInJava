package Lesson1;

public class Task1 {
    private static final int arr[] = {-55, 11, -23, -63, 54, 95, 106, 12, -40, 49, 0, 13, -9, 9};

    private static void findThreeSumInArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        System.out.printf("arr[%d]+arr[%d]+arr[%d] == 0%n", i, j, k);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        findThreeSumInArray(arr);
    }
}