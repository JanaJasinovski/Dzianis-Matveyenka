package com.dmdev.task2;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(sum(12345));
        System.out.println(sumFor(12345));
    }

    public static int sum(int value) {
        int result = 0;
        int currentValue = value;
        while (currentValue != 0) {
            result += currentValue % 10;
            currentValue /= 10;
        }
        return result;
    }

    public static int sumFor(int value) {
        int result = 0;
        int currentValue = value;
        for (; currentValue != 0 ; currentValue /= 10) {
            result += currentValue % 10;
        }
        return result;
    }
}
