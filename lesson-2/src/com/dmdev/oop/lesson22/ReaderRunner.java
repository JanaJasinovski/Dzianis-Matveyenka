package com.dmdev.oop.lesson22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class ReaderRunner {
    public static void main(String[] args) {
        File file = Path.of("resources", "test.txt").toFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String collect = reader.lines()
                    .collect(Collectors.joining("\n"));

            System.out.println(collect );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
