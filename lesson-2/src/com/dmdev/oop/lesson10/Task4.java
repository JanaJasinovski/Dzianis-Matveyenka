package com.dmdev.oop.lesson10;

public class Task4 {
    public static void main(String[] args) {
        String value ="rgrge.erf?!erg,";
        System.out.println(countSymbols(value));
    }

    public static int countSymbols(String value) {
        String result = value.replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "");

        return value.length() - result.length();
    }
}
