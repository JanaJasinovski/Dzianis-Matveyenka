package com.dmdev.oop.lesson21.task;

import java.util.List;
import java.util.OptionalDouble;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 3, 4, 6, 8, 5, 15, 20, 25, 10);
        OptionalDouble average = integers.stream()
                .filter(s -> s % 2 != 0 && s % 5 == 0)
                .mapToInt(Integer::intValue)
                .average();

        average.ifPresent(System.out::println);
    }
}
