package com.ifmo.lesson2;

public class First20 {
    /*
     Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8
     16 32 64 128 ….
     */
    public static void main(String[] args) {
        // TODO implement
        int i = 2;
        for ( int j = 1; j < 21; j++ )
        {
            System.out.printf("%d ", i);
            i *= 2;
        }
    }
}
