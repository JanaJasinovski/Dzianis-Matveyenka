package com.dmdev.oop.lesson20.exception.test;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Random;

public class Task6 {
    private static final Map<Integer, Throwable> EXCEPTIONS = Map.of(
            0, new RuntimeException("runtime"),
            1, new FileNotFoundException("file not found"),
            2, new IndexOutOfBoundsException("index exception")
    );
    public static void main(String[] args) {
        Random random = new Random();
        try {
            unsafe(random.nextInt(3));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("1");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("2");
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.out.println("3");
            e.printStackTrace();
        } catch (Throwable e) {
            System.out.println("4");
            e.printStackTrace();
        }

    }

    public static void unsafe(int randomValue) throws Throwable {
        Throwable exception = EXCEPTIONS.getOrDefault(randomValue, new DmdevException("not found"));
        throw exception;
    }
}
