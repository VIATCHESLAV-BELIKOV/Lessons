package com.ifmo.lesson3;

import java.util.Random;

public class EvenArray {
    /*
    Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива на экран
    сначала в строку, отделяя один элемент от другого пробелом, а затем в столбик (отделяя один
    элемент от другого началом новой строки). Перед созданием массива подумайте, какого он
    будет размера.2 4 6 … 18 20246…20
     */
    public static void main(String[] args) {
        int[] evenArray = evenArray();

        // TODO implement

        for (int i = 0; i < evenArray.length; i ++) System.out.printf( "%d ", evenArray[i] );
        System.out.println("");
        for (int i = 0; i < evenArray.length; i ++) System.out.printf( "%d\n", evenArray[i] );

    }

    public static int[] evenArray() {
        // TODO implement
        int[] iArray = new int[(20-2)/2+1];
        int j = 0;
        Random r = new Random();
        for (int i = 2; i <= 20; i ++)
            if ( (i % 2 ) == 0 ) {
                iArray[j] = i;
                j++;
            }
        return iArray;
    }
}
