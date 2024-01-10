package com.dmdev.oop.lesson10;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(format("Ivan", "Petrov", "sidorovich"));
    }

    public static String format(String firstName, String lastName, String patronymicName) {
        return String.format("%s.%s.%s", Character.toUpperCase(firstName.charAt(0)),  Character.toUpperCase(lastName.charAt(0)) , Character.toUpperCase(patronymicName.charAt(0))) ;
    }
}
