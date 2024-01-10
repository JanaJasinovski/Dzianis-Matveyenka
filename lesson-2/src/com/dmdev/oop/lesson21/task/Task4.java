package com.dmdev.oop.lesson21.task;

import java.util.List;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(5, 2, 4, 2, 1);
        String result = integers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",", "Prefix: ", " end"));
        System.out.println(result);
    }
}
