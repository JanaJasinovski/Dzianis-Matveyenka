package com.dmdev.oop.lesson20.exception.test;

public class Task5 {
    public static void main(String[] args) {
        try {
            catchCustomException();
        } catch (DmdevException e) {
            System.out.println("catched in main");
        }
    }

    private static void catchCustomException() {
        try {
            unsafe();
        }catch (RuntimeException e) {
            System.out.println("Catch int catchCustomException method");
            throw new DmdevException(e);
        }
    }

    private static void unsafe()  {
        throw new RuntimeException("ooops");
    }
}
