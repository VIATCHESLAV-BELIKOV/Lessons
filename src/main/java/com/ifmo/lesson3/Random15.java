package com.ifmo.lesson3;

import java.util.Random;

public class Random15 {
    /*
     Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на экран.
     Подсчитайте сколько в массиве чётных элементов и выведете это количество на экран на
     отдельной строке.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        // TODO implement

        int evens = evens(randomNumbers);

        // TODO implement
        System.out.println(evens);

    }

    public static int[] randomNumbers() {
        // TODO implement
        int[] iArray = new int[15];
        Random r = new Random();
        for (int i = 0; i < iArray.length; i ++) iArray[i] = r.nextInt(9);
        return iArray;
    }

    private static int evens(int[] arr) {
        // TODO implement
        int iEven = 0;
        for (int i = 0; i < arr.length; i ++) if ( ( arr[i] % 2 ) == 0 ) iEven++;
        return iEven;
    }
}
