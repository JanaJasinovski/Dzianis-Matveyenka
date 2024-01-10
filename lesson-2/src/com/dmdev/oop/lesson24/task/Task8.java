package com.dmdev.oop.lesson24.task;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Task8 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime localDateTime = now.with(temporal -> temporal.plus(42L, ChronoUnit.DAYS));
        System.out.println(localDateTime);
    }
}
