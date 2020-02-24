package Lesson4.Lesson;

import java.util.Iterator;

public class OneLinkedList<T> implements Iterable<T> {

    private Item first;
    private Item last;

    private class Item{
        private T value;
        private Item prev;
    }

    public OneLinkedList(){
        first = new Item();
        last = new Item();
        last.prev = first;
    }

    public void add(T value){
        Item item = new Item();
        item.value = value;
        item.prev = last.prev;
        last.prev = item;
    }

    private Item getItem(int ix){
        Item cur = last.prev;
        for (int i = 0; i < ix; i++) {
            if (cur == first){
                return first;
            }
            cur = cur.prev;
        }
        return cur;
    }

    public T get(int ix){
        Item item = getItem(ix);
        if (item == first){
            return null;
        }
        return item.value;
    }

//    public void delete(int ix){
//        Item item = getItem(ix);
//        if (item == first){
//            return;
//        }
//        item.prev
//    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Item cur = last.prev;

            @Override
            public boolean hasNext() {
                return cur != first;
            }

            @Override
            public T next() {
                T res = cur.value;
                cur = cur.prev;
                return res;
            }
        };
    }

    @Override
    public String toString() {
        Item cur = last.prev;
        StringBuilder sb = new StringBuilder();
        while (cur != first){
            sb.append(cur.value + ", ");
            cur = cur.prev;
        }
        System.out.println();
        return sb.substring(0, sb.length() - 2);
    }

    public static void main(String[] args) {
        OneLinkedList<Integer> list = new OneLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(10);
        list.add(1234);
        System.out.println(list.toString());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(3));

        System.out.println("__________________");
        for (Integer val : list){
            System.out.println(val);
        }
    }
}
