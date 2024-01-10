package com.dmdev.oop.lesson20.task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task4 {
    public static void main(String[] args) {
        Map<Integer, Integer> polynomial1 = Map.of(
                0, 5,
                1, 3,
                3, 2,
                5, 4,
                6, 7
        );

        Map<Integer, Integer> polynomial2 = Map.of(
                0, 5,
                3, 4,
                5, 5,
                6, 1
        );

        System.out.println(convertToString(sum(polynomial1, polynomial2)));
    }

    private static String convertToString(Map<Integer, Integer> map) {
        Map<Integer, Integer> result = new TreeMap<>(Comparator.reverseOrder());
        result.putAll(map);

        List<String> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            String value = entry.getKey() == 0
                    ? String.valueOf(entry.getValue())
                    : entry.getValue() + "x^" + entry.getValue();
            list.add(value);
        }
        return String.join(" + ", list);
    }

    public static Map<Integer, Integer> sum(Map<Integer, Integer> polynomial1,
                                            Map<Integer, Integer> polynomial2) {
        Map<Integer, Integer> polynomialResult = new HashMap<>(polynomial1);
        for (Map.Entry<Integer, Integer> entry : polynomialResult.entrySet()) {
//            Integer value = polynomialResult.getOrDefault(entry.getKey(), 0);
//            polynomialResult.put(entry.getKey(), value + entry.getValue());

            polynomialResult.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        return polynomialResult;

    }
}
