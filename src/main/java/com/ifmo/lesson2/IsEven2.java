package com.ifmo.lesson2;

public class IsEven2 {
    /*
    Создать программу, проверяющую и сообщающую на экран, является ли целое число
    записанное в переменную n, чётным либо нечётным.
     */
    public static void main(String[] args) {
        int n = 24;

        System.out.println(isEven(n));
    }

    public static String isEven(int n) {
        // TODO implement
        // Допустимые строки: "Четное" или "Нечетное"
        if ( (n != 0) && ((n & 1) == 1) ) return "Нечетное";

        if ( (n % 2) == 1 ) return "Нечетное";

        return "Четное";
    }
}
