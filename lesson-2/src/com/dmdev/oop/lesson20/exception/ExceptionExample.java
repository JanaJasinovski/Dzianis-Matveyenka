package com.dmdev.oop.lesson20.exception;

import java.io.FileNotFoundException;

public class ExceptionExample {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("main start");
        try {
            unsafe(10);
        }  finally {
            System.out.println("finally");
        }
        System.out.println("main end");

    }

    public static void unsafe(int value) throws FileNotFoundException {
        if(value > 0) {
            throw new FileNotFoundException();
        }
    }
}
