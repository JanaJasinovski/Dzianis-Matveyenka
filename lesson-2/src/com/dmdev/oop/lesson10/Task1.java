package com.dmdev.oop.lesson10;

public class Task1 {
    public static void main(String[] args) {
        String value = "wfwefwe :( rergerg :( wrfr :) ";
        System.out.println(replace(value));
    }

    public static String replace(String value) {
        return value.replace(":(", ":)");
    }
}
