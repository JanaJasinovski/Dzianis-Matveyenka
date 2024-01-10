package com.dmdev.task2;

public class RecursionExample {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static int factorial(int value) {
        if(value == 1) {
            return 1;
        }

        return value * factorial(value - 1);
    }
}
