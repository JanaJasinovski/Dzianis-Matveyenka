package com.dmdev.oop.lesson22.task;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Task1 {
    public static final String VOWELS = "уеыаоэюия";
    public static void main(String[] args) {

        Path path = Path.of("resources", "test.txt");
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                char firstSymbol = word.charAt(0);
                if (VOWELS.indexOf(firstSymbol) != -1) {
                    System.out.println(word);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
