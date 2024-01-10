package com.dmdev.oop.lesson21;


import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<String> strings = List.of("88","11", "22", "33", "44", "55", "66");
//        for (String string : strings) {
//            String value = string + string;
//            Integer intValue = Integer.valueOf(value);
//            if(intValue % 2 == 0) {
//                System.out.println(intValue);
//            }
//        }

        System.out.println();

        IntSummaryStatistics intSummaryStatistics = strings.stream()
                .map(s -> s + s)
                .map(Integer::valueOf)
                .filter(integer -> integer % 2 == 0)
                .sorted()
//                .skip(1)
                .limit(2)
                .mapToInt(Integer::intValue)
//                .mapToObj(Integer::valueOf)
                .summaryStatistics();

        List<String> collect = Stream.of("88", "11", "22", "33", "44", "55", "66")
                .peek(System.out::println)
                .toList();

        IntStream.range(0,10)
                .forEach(System.out::println);

        IntStream.iterate(0, operand -> operand + 3)
                .skip(10)
                .limit(20)
                .forEach(System.out::println);

        System.out.println(intSummaryStatistics);
//                .forEach(System.out::println);


    }
}
