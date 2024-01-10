package com.dmdev.task2;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(sum(24));
    }
    public static double sum(int sourceSum) {
        double result = sourceSum;
        for (int i = 1626 + 1; i <= 2020; i++) {
            double percent = result * 0.05;
            result += percent;
            System.out.println(i + " : " + result);
        }
        return result;
    }
}
