package com.dmdev.oop.lesson26.atomic;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        int i = atomicInteger.incrementAndGet();
        System.out.println(i);

        int newValue = atomicInteger.addAndGet(20);
        System.out.println(newValue);

    }
}
