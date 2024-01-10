package com.dmdev.oop.lesson19;

import com.dmdev.oop.lesson18.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> list = new List<String>(10);
        list.add("string1");
        list.add("string2");
        list.add("string3");
        list.add("string4");
        list.add("string5");

        for (String value : list) {
            System.out.println(value);
        }

        list.iterator().forEachRemaining(System.out::println);
        list.forEach(System.out::println);
    }
}
