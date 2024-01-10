package com.dmdev.oop.lesson20.exception.test;

public class DmdevException extends RuntimeException {

    public DmdevException(String message) {
        super(message);
    }

    public DmdevException(Throwable cause) {
        super(cause);
    }
}
