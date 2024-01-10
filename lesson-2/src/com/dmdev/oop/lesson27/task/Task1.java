package com.dmdev.oop.lesson27.task;

import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        String regex = "[a-zA-Z]\\w*@\\w{3,}\\.(org|com)";
        String input = "dmdex@gmail.com";
        System.out.println(Pattern.matches(regex, input));
    }
}
