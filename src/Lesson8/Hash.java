package Lesson8;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Link {
    public int value;
    public Link next;

    public Link(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}


class T {
    private Link data;

    public T(Link data){
        this.data = data;
    }

    public int getKey(){
        return this.data.getValue();
    }
}

class HashTable{
    private T[] hashArr;
    private int arrSize;
    private T nonItem;

    public HashTable(int size){
        this.arrSize = size;
        hashArr = new T[arrSize];
        nonItem = new T(new Link(-1));
    }

    public void display(){
        for(int i=0;i<arrSize;i++){
            if(hashArr[i] !=null){
                System.out.println(hashArr[i].getKey());
            } else {
                System.out.println("***");
            }
        }
    }

    public int hashFunc(int key){
        return key % arrSize;
    }

    public void insert(T item){
        int key = item.getKey();
        int hashVal = hashFunc(key);
        System.out.println("key: " + key + " hashVal: " + hashVal);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal%=arrSize;
        }

        hashArr[hashVal] = item;
    }

    public T delete(int key){
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key){
                T temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal%=arrSize;
        }
        return null;
    }

    public T find(int key){
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key){
                return hashArr[hashVal];
            }
            ++hashVal;
            hashVal%=arrSize;
        }
        return null;
    }
}

public class Hash {

    public static void main(String[] args) throws IOException {
        T aDataItem;
        int aKey, size, n, keysPerCell;
        // Ввод размеров
        System.out.print("Enter size of hash table: ");
        size = getInt();
        do {
            System.out.print("Enter initial number of items: ");
            n = getInt();
            if (n > size){
                System.out.println("Entered more than size!");
            }
        }
        while (n > size);
        keysPerCell = 10;
        // Создание таблицы
        HashTable theHashTable = new HashTable(size);
        for(int j=0; j<n; j++){
            aKey = (int)(java.lang.Math.random() * keysPerCell * size);
            aDataItem = new T(new Link(aKey));
            theHashTable.insert(aDataItem);
        }
        while(true){
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");
            char choice = getChar();
            switch(choice){
                case 's':
                    theHashTable.display();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new T(new Link(aKey));
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if(aDataItem != null){
                        System.out.println("Found " + aKey);
                    }else
                        System.out.println("Could not find " + aKey);
                    break;
                case 'e':
                    return;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }
    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    public static char getChar() throws IOException{
        String s = getString();
        return s.charAt(0);
    }
    public static int getInt() throws IOException{
        String s = getString();
        return Integer.parseInt(s);
    }

}