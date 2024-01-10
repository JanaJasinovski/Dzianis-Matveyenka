package com.dmdev.task2;

public class Task5 {
    public static void main(String[] args) {
        printLetters();
        char value = 'd';
        System.out.println((int) value);
    }

    public static void printLetters() {
        for (char letter = 'b'; !isVowel(letter) ; letter++) {
            System.out.println(letter);
        }
    }

    private static boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'y' ||
                letter == 'u' || letter == 'i' || letter == 'o';
    }
}
