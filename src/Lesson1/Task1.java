package Lesson1;

public class Task1 {
    private static final int arr[] = {-55, 11, -23, -63, 54, 95, 106, 12, -40, 49, 0, 13, -9, 9};

    public static void main(String[] args) {
        int check = arr.length - 2;
        if (check > 0) {
            int a = 0;
            int b = 1;
            int c = 2;
            int i = 0;
            while (a != check){
                if (arr[a] + arr[b] + arr[c] == 0) {
                    System.out.println(arr[a] + " + " + arr[b] + " + " + arr[c] + " = 0");
                }
                if (c == arr.length - 1){
                    if (b == arr.length - 2){
                        a++;
                        b = a + 1;
                    } else {
                        b++;
                    }
                    c = b + 1;
                } else {
                    c++;
                }
                i++;
            }
            System.out.println("The number of combinations without repetition: " + i);
        } else {
            System.out.println("The array is small!");
        }
    }
}
