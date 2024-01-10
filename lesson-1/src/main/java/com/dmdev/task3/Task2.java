package com.dmdev.task3;

public class Task2 {
    public static void main(String[] args) {
        int[] values = new int[100];
        fillArray(values);
        Task1.printArray(values);
    }

    public static void fillArray(int[] values) {
        int currentIndex = 0;
        for (int i = 1; currentIndex < values.length; i++) {
            if (i % 13 == 0 || i % 17 == 0){
                values[currentIndex] = i;
                currentIndex++;
            }
        }
    }
}
