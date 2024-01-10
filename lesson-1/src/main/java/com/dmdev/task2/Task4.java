package com.dmdev.task2;

public class Task4 {
    public static void main(String[] args) {
        int value = 20;
        boolean result = isSimple(value);
        System.out.println(result);
    }
    public static boolean isSimple(int value) {
        boolean result = true;
        for (int i = 2; i < value; i++) {
            if(value % i== 0 ) {
                result = false;
                break;
            }
        }
        return result;
    }
}
