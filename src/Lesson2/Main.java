package Lesson2;
/*      1. Создать массив большого размера (миллион элементов).
        2. Написать методы удаления, добавления, поиска элемента массива.
        3. Заполнить массив случайными числами.
*/
public class Main {

    public static void main(String[] args) {
        MyArray array = new MyArray(1000000);
        array.createArray();

        array.showPartArray(5, 20);
        array.showPartArray(15, 30);
        array.set(15, 777);
        array.findIndexInArray(19);
        array.delete(19);
        array.findIndexInArray(19);
        array.showPartArray(5, 20);
        array.showPartArray(15, 30);

        long time = System.currentTimeMillis();
        array.showPartArray(0, 30);
//        array.bubbleSort();
//        array.selectionSort();
//        array.insertionSort();
        array.mergeSort();
        array.showPartArray(0, 30);
        System.out.println("Time, ms: " + (System.currentTimeMillis() - time));
    }
}
