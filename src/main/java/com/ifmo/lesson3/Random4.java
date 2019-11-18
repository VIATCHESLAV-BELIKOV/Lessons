package com.ifmo.lesson3;

import java.util.Arrays;
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
        System.out.println(Arrays.toString(randomNumbers));
 //       for (int i = 0; i < randomNumbers.length; i ++) System.out.printf("%d ", randomNumbers[i]);
        System.out.println(isIncreasingSequence(randomNumbers));
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
        boolean bRet = true;
        for (int i = 1; i < randomNumbers.length; i ++)
            if ( randomNumbers[i] < randomNumbers[i-1]) {
                bRet = false;
                break;
            }
        return bRet;
    }
}
