package Lesson3.Lesson;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int arr[], int value){
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (value < arr[mid]){
                hi = mid - 1;
            } else if (value > arr[mid]){
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
