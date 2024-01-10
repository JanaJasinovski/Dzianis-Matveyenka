package com.dmdev.oop.lesson20.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        new HashSet<>();
        new LinkedHashSet<>();
        Set<String> set = new TreeSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        set.add("ddd");
        set.add("bbb");

        System.out.println(set);
    }
}
