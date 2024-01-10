package com.dmdev.task3;

public class Task4 {
    static int[] values = {1, 2, 0, 5, 6, 4, 10, 3};

    public static void main(String[] args) {
        System.out.println("max index: " + findMaxIndex(values));
        System.out.println("min index: " +findMinIndex(values));
        System.out.println("sum: " + calculateSumBetween(findMinIndex(values), findMaxIndex(values)));
    }

    public static int calculateSumBetween(int min, int max) {
        int sum = 0;

        if(min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        for (int i = min + 1; i < max; i++) {
            sum += values[i];
        }
        return sum;
    }

    public static int findMinIndex(int[] values) {
        int minValue = values[0];
        int minIndex = 0;
        for (int i = 0; i < values.length; i++) {
            if(minValue > values[i]) {
                minValue = values[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int findMaxIndex(int[] values) {
        int maxValue = values[0];
        int maxIndex = 0;
        for (int i = 0; i < values.length; i++) {
            if(maxValue < values[i]) {
                maxValue = values[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
