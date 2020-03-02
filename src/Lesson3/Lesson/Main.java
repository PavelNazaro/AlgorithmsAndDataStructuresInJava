package Lesson3.Lesson;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person[] arr = {
                new Person("Иванов", "Иван", 24),
                new Person("Петров", "Иван", 25),
                new Person("Сидоров", "Иван", 27),
                new Person("Иванов", "Иван", 25),
                new Person("Иванов", "Иван", 28)
        };

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
 
    public static <T> void insertionSort(Comparable<T>[] arr) {
        for (int i=1; i<arr.length; i++) {
            Comparable<T> tmp = arr[i];
            int j=i;
//            while (j>0 && arr[j-1] > tmp) {
            while (j>0 && arr[j-1].compareTo((T) tmp) < 0) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = tmp;
        }
    }
}
