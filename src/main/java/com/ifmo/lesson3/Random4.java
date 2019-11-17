package com.ifmo.lesson3;

import java.util.Random;

public class Random4 {
    /*
    Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его на экран в
    строку. Определить и вывести на экран сообщение о том, является ли массив строго
    возрастающей последовательностью.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        // TODO implement
        for (int i = 0; i < randomNumbers.length; i ++) System.out.printf("%d ", randomNumbers[i]);
        System.out.println("");
        
    }

    public static int[] randomNumbers() {
        // TODO implement
        int[] iArray = new int[4];
        Random r = new Random();
        for (int i = 0; i < iArray.length; i ++) iArray[i] = r.nextInt(89) + 10;
        return iArray;
    }

    public static boolean isIncreasingSequence(int[] randomNumbers) {
        // TODO implement

        return false;
    }
}
