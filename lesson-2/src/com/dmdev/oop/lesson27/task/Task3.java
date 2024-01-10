package com.dmdev.oop.lesson27.task;

public class Task3 {
    public static void main(String[] args) {
        String regex = "(<p .+?>)(.+?</p>)";
        String input = "<p> wgrgerg </p> </b> gergergr <p id=\"p1\"> ergerg </p>" +
                "gerger <p> rgerg rgerg <p id=\"p2\" rgerge  <p> rerg>";
        System.out.println(input.replaceAll(regex, "<p>$2"));
    }
}
