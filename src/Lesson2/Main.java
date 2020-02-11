package Lesson2;
/*      1. Создать массив большого размера (миллион элементов).
        2. Написать методы удаления, добавления, поиска элемента массива.
        3. Заполнить массив случайными числами.
*/
public class Main {

    public static void main(String[] args) {
        MyArray arr = new MyArray(1000000);
        arr.createArray();
        arr.showPartArray(5, 20);
        arr.showPartArray(15, 30);
        arr.set(15, 777);
        arr.findIndexInArray(19);
        arr.delete(19);
        arr.findIndexInArray(19);
        arr.showPartArray(5, 20);
        arr.showPartArray(15, 30);
    }
}
