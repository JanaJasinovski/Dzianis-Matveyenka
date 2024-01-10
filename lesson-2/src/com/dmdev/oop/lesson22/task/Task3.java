package com.dmdev.oop.lesson22.task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task3 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("resources", "test.txt");
        Files.readAllLines(path).stream()
                .map(Task3::findMaxDigitsCount)
                .forEach(System.out::println);
    }

    private static Integer findMaxDigitsCount(String line) {
        Integer result = 0;
        int counter = 0;

        for (int i = 0; i < line.length(); i++) {
            if(Character.isDigit(line.charAt(i))) {
                counter++;
            } else {
                if(result < counter) {
                    result = counter;
                }

                counter = 0;
            }
        }
        return result;
    }
}
