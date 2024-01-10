package com.dmdev.oop.lesson20.task;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 6, 8, 9, 13, 20);
        System.out.println(removeEven(list));
    }

    private static List<Integer> removeEven(List<Integer> list) {
        List<Integer> result = new ArrayList<>(list);
        for (Integer value : list) {
            if(value % 2 == 0) {
                result.remove(value);
            }
        }
        return result;
    }
}
