package com.ifmo.lesson2;

import java.util.Random;

public class BiggestInRandom {
    /*
     Создать программу, выводящую на экран случайно сгенерированное трёхзначное
     натуральное число и его наибольшую цифру.Примеры работы программы:
     В числе 208 наибольшая цифра 8.
     В числе 774 наибольшая цифра 7.
     В числе 613 наибольшая цифра 6.
     */
    public static void main(String[] args) {
        int rnd = threeDigitRandom();

        String largestDigit = largestDigit(rnd);

        System.out.println(largestDigit);
    }

    public static int threeDigitRandom() {
        // TODO implement
        Random r = new Random();
        return r.nextInt(899) + 100;
    }

    public static String largestDigit(int rnd) {
        // TODO implement

        int max = 0;

        int j = rnd;
        int k = 0;
        while ( j != 0 )
        {
            k = j % 10;
            if ( k > max ) max = k;
            j /= 10;
        }
        return "В числе " + rnd + " наибольшая цифра " + max + ".";
    }
}
