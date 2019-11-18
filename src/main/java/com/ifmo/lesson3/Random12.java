package com.ifmo.lesson3;

import java.util.Random;

public class Random12 {
    /*
    Создайте массив из 12 случайных целых чисел из отрезка [-15;15]. Определите какой
    элемент является в этом массиве максимальным и сообщите индекс его последнего
    вхождения в массив.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        // TODO implement
        for (int i = 0; i < randomNumbers.length; i ++)
            System.out.printf( "%d ", randomNumbers[i] );
    //    System.out.printf("\nsize=%d\n", randomNumbers.length );

        int max = max(randomNumbers);
        int maxLastIndex = lastIndexOf(randomNumbers, max);

        // TODO implement
        System.out.println(maxLastIndex);

    }

    public static int[] randomNumbers() {
        // TODO implement
        int[] iArray = new int[12];
        Random r = new Random();
        for (int i = 0; i < iArray.length; i ++) iArray[i] = r.nextInt(25) - 15;
        return iArray;
    }

    public static int max(int[] randomNumbers) {
        // TODO implement
        int maxN = randomNumbers[0];
        for (int i = 0; i < randomNumbers.length; i ++) {
            if ( randomNumbers[i] > maxN ) maxN = randomNumbers[i];
        }
        return maxN;
    }

    public static int lastIndexOf(int[] randomNumbers, int max) {
        // TODO implement
        int maxI = -1;
        for (int i = 0; i < randomNumbers.length; i ++) {
            if ( randomNumbers[i] >= maxI ) maxI = i;
        }
        return maxI;
    }
}
