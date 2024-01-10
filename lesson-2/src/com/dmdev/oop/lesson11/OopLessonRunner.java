package com.dmdev.oop.lesson11;

public class OopLessonRunner {
    public static void main(String[] args) {
        Laptop laptop = new Laptop(new Ssd(250), new Ram(512), 2);
        laptop.open();
        laptop.load();
    }
}
