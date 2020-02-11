package Lesson2;

public class MyArray {
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
}
