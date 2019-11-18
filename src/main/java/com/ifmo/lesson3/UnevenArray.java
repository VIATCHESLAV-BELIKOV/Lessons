package com.ifmo.lesson3;

import java.util.Random;

public class UnevenArray {
    /*
    Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку, а затем
    этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 … 7 5 3
    1)
     */
    public static void main(String[] args) {
        int[] unevenArray = unevenArray();

        // TODO implement
        for (int i = 0; i < unevenArray.length; i ++) System.out.printf( "%d ", unevenArray[i] );
        System.out.println("");
        for (int i = unevenArray.length - 1; i >= 0; i --) System.out.printf( "%d ", unevenArray[i] );
        System.out.println("");

    }

    public static int[] unevenArray() {
        // TODO implement
        int[] iArray = new int[(99-1)/2+1];
        int j = 0;
        Random r = new Random();
        for (int i = 1; i <= 99; i ++)
            if ( (i % 2 ) != 0 ) {
                iArray[j] = i;
                j++;
            }
        return iArray;
    }
}
