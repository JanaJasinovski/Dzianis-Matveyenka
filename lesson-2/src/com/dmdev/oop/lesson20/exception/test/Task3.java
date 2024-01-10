package com.dmdev.oop.lesson20.exception.test;

public class Task3 {
    public static void main(String[] args) {
        try {
            unsafe();
        } catch (DmdevException e) {
            System.err.println(e.getCause());
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static void unsafe() throws DmdevException {
        throw new DmdevException("Test exception");
    }
}
