package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.Random;

public class Random8 {
    /*
    Создайте массив из 8 случайных целых чисел из отрезка [1;10]. Выведите массив на экран
    в строку. Замените каждый элемент с нечётным индексом на ноль. Снова выведете массив на
    экран на отдельной строке.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        // TODO implement
        System.out.println(Arrays.toString(randomNumbers));

        int[] replacedWithZeros = replaceWithZeros(randomNumbers);

        // TODO implement
        System.out.println(Arrays.toString(replacedWithZeros));
 
    }

    public static int[] randomNumbers() {
        // TODO implement
        int[] iArray = new int[10];
        Random r = new Random();
        for (int i = 0; i < iArray.length; i ++) iArray[i] = r.nextInt(9) + 1;
        return iArray;
    }

    public static int[] replaceWithZeros(int[] randomNumbers) {
        // TODO implement
        int[] iArray = new int[randomNumbers.length];
        for (int i = 0; i < iArray.length; i ++) iArray[i] = ( i % 2 == 0 ) ?  randomNumbers[i] : 0;
        return iArray;
    }
}
