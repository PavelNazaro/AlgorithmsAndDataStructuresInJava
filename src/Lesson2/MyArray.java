package Lesson2;

public class MyArray{
    private int[] arr;
    private int len;

    public MyArray(int len) {
        this.arr = new int[len];
        this.len = len;
    }

    public void createArray() {
        for (int i = 0; i < len; i++) {
            set(i, (int) (Math.random() * 100));
        }
    }

    public void showPartArray(int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(arr[i] + " ");;
        }
        System.out.println();
    }

    public void showAllArray() {
        for (int index : arr){
            System.out.print(index + " ");;
        }
        System.out.println();
    }

    public void findIndexInArray(int i) {
        System.out.printf("Index %d: %d%n", i, arr[i]);
    }

    public void set(int ix, int value) {
        arr[ix] = value;
    }

    public int get(int ix) {
        return arr[ix];
    }

    public void delete(int ix) {
        for (int i=ix; i<len - 1; i++) {
            arr[i] = arr[i+1];
        }
        if (len > 0) {
            len--;
        }
        System.out.println("Delete ok!");
    }

    public void bubbleSort() {
        for (int i=arr.length-1; i > 0; i--) {
            for (int j=0; j<i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public void selectionSort() {
        for (int i=0; i<arr.length; i++) {
            int minIx = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] < arr[minIx]) {
                    minIx = j;
                }
            }
            swap(arr, i, minIx);
        }
    }

    public void insertionSort() {
        for (int i=1; i<arr.length; i++) {
            int tmp = arr[i];
            int j=i;
            while (j>0 && arr[j-1] > tmp) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = tmp;
        }
    }

    // N * Log (N)
    public void mergeSort() {
        int[] tmp = new int[arr.length];
        mergeSortInt(arr, tmp, 0, arr.length-1);
    }

    private void mergeSortInt(int[] arr, int[] tmp, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSortInt(arr, tmp, lo, mid);
        mergeSortInt(arr, tmp, mid+1, hi);
        merge(arr, tmp, lo, mid, hi);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void merge(int[] arr, int[] tmp, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            tmp[k] = arr[k];
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid){
                arr[k] = tmp[j++];
            } else if (j > hi) {
                arr[k] = tmp[i++];
            } else if (tmp[j] < tmp[i]) {
                arr[k] = tmp[j++];
            } else {
                arr[k] = tmp[i++];
            }
        }
    }
}
