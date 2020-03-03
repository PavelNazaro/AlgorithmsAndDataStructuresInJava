package Lesson3.Homework;

import Lesson3.Lesson.Stack;

import java.util.Scanner;

public class ReadingInReverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = in.nextLine();
        in.close();

        System.out.println("Reverse input string: " + printReverseString(str));
    }

    private static String printReverseString(String str) {
        Stack<Character> characterStack = new Stack<>(str.length());

        for (char ch : str.toCharArray()){
            characterStack.push(ch);
        }

        str = "";

        while (!characterStack.isEmpty()){
            str += characterStack.pop();
        }

        return str;
    }
}
