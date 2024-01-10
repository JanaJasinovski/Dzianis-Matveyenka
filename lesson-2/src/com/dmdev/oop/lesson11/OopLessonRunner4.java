package com.dmdev.oop.lesson11;

public class OopLessonRunner4 {
    public static void main(String[] args) {
        Printable laptop = new Laptop(new Ssd(250), new Ram(1024), 2);
        Printable mobile = new Mobile(new Ssd(125), new Ram(512));

        print(laptop, mobile);
        printWithRandom(laptop, mobile);
    }

    public static void print(Printable... printable) {
        for (Printable printable1 : printable) {
            printable1.print();
        }
    }

    public static void printWithRandom(Printable... printable) {
        for (Printable printable1 : printable) {
            printable1.printWithRandom();
        }
    }
}
