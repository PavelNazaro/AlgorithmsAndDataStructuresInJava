package Lesson4.Lesson;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
//        Integer[] arr = {500, 20, -1, 300, 700, 1, 4, 5, 4, 3, 0};
//        qsort(arr);
        int[] arr = {3, 0, 5, 3, 1, 7, 4, 0, 9, 1, 2, 7};
        countSort(arr, 9);
        System.out.println(Arrays.toString(arr));
    }

    public static void qsort(Comparable[] arr){
        qsort(arr, 0, arr.length - 1);
    }

    private static void qsort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo){
            return;
        }
        int mid = partition(arr, lo, hi);
        qsort(arr, lo, mid - 1);
        qsort(arr, mid + 1, hi);
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable<?> base = arr[lo];

        while (true){
            while (less(arr[++i], base)){
                if (i == hi){
                    break;
                }
            }

            while (less(base, arr[--j])){
                if (j == lo){
                    break;
                }
            }

            if (i >= j){
                break;
            }

            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    private static boolean less(Comparable a, Comparable b){
        if (a == b){
            return false;
        }
        return a.compareTo(b) < 0;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void countSort(int[] arr, int maxItemValue){
        int[] count = new int[maxItemValue + 1];

        for (int item : arr){
            count[item]++;
        }

        int j = 0;
        for (int i = 0; i < maxItemValue; i++) {
            for (int k = 0; k < count[i]; k++) {
                arr[j++] = i;
            }
        }
    }
}
