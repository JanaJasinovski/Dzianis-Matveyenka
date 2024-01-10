package com.dmdev.task2;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorialWhile(5));
    }

    public static int factorialWhile(int value) {
        int result = 1;
        int factorial = 1;
        while (result <= value) {
            factorial *= result;
            result++;
        }
        return factorial;
    }

    public static int factorial(int value) {
        int result = 1;
        for (int i = 1; i <= value; i++) {
            result *= i;
        }

        return result;
    }
}
