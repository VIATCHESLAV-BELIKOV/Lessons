package com.ifmo.lesson2;

public class First55 {
    /*
    Создайте программу, выводящую на экран первые 55 элементов последовательности 1 3 5 7 9 11 13 15 17 ….
     */
    public static void main(String[] args) {
        // TODO implement

        int i = 1;
        for ( int j = 1; j < 56; j++ )
        {
            System.out.printf("%d ", i);
            i += 2;
        }
    }
}
