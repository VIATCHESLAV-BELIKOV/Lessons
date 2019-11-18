package com.ifmo.lesson3;

import java.util.Random;

public class TwoArrays {
    /*
     Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый, выведите
     массивы на экран в двух отдельных строках. Посчитайте среднее арифметическое элементов
     каждого массива и сообщите, для какого из массивов это значение оказалось больше (либо
     сообщите, что их средние арифметические равны).
     */
    public static void main(String[] args) {
        int[] randomNumbers1 = randomNumbers();
        int[] randomNumbers2 = randomNumbers();

        // TODO implement
        for (int i = 0; i < randomNumbers1.length; i ++)
            System.out.printf( "%d ", randomNumbers1[i] );
        System.out.println("");
        for (int i = 0; i < randomNumbers2.length; i ++)
            System.out.printf( "%d ", randomNumbers2[i] );
        System.out.println("");

        int average1 = average(randomNumbers1);
        int average2 = average(randomNumbers2);

        // TODO implement


    }

    public static int[] randomNumbers() {
        // TODO implement
        int[] iArray = new int[5];
        Random r = new Random();
        for (int i = 0; i < iArray.length; i ++) iArray[i] = r.nextInt(5);
        return iArray;
    }

    public static int average(int[] randomNumbers) {
        // TODO implement
        int iSum = 0;
        for (int i = 0; i < randomNumbers.length; i ++) iSum += randomNumbers[i];
        return iSum/5;
    }
}
