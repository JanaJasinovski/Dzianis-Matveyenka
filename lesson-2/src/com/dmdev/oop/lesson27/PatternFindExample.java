package com.dmdev.oop.lesson27;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFindExample {
    public static void main(String[] args) {
        String phoneNumber = "wefwefwe wfwefwfw+375 (33) 898-12-13 wfwefwef +375 (33) 777-12-13" +
                "ergergerg +375 (44) 898-32-44 rfwef +375 (12) 224-12-13 reger";
        String regex = "(?:\\+375)? ?(?<code>\\(\\d{2}\\)) ?(\\d{3})-(\\d{2})-(\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            String group1 = matcher.group(2);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);
            matcher.appendReplacement(stringBuilder, "$2 - $3 - $4");
        }
        matcher.appendTail(stringBuilder);
        System.out.println(stringBuilder);
        System.out.println(phoneNumber.replaceAll(regex, "$2 - $3 - $4"));
    }
}
