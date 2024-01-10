package com.dmdev.oop.lesson22;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class WriterRunner {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("resources", "writer2.poem");
        Files.write(path, List.of("Hello World", "Java"));

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        }

//        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
//            writer.append("Hello World!");
//            writer.newLine();
//            writer.append("Java");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
