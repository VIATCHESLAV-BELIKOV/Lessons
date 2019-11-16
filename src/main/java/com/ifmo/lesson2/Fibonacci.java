package com.ifmo.lesson2;

public class Fibonacci {
    /*
     Выведите на экран первые 11 членов последовательности Фибоначчи. Напоминаем, что
     первый и второй члены последовательности равны единицам, а каждый следующий — сумме
     двух предыдущих.
     */
    public static void main(String[] args) {
        // TODO implement
        int[] f = new int[11];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < 11; ++i) f[i] = f[i - 1] + f[i - 2];
        for (int i = 0; i < 11; i++) System.out.printf("%d",f[i]);
        }

}
