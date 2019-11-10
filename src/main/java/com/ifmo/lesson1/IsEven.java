package com.ifmo.lesson1;

public class IsEven {
    /*
    Напишите программу, которая выводит true, если число четное и false, если нет.
    Попробуйте сделать при помощи битовых операций.
     */
    public static void main(String[] args) {
        int n = 24;

        System.out.printf( "%d is %s\n", n, (isEven(n) ? "even" : "odd") );
    }

    public static boolean isEven(int n) {
        // TODO implement
        // 1 способ. побитовое определение четности
        if ( (n != 0) && ((n & 1) == 0) ) return true;
        // 2 способ. остаток от деления на 2
        // if (  n != 0  &&  ( n % 2 ) == 0 ) return true;
        return false;
    }
}
