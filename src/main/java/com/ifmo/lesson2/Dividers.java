package com.ifmo.lesson2;

import java.util.Scanner;

public class Dividers {
    /*
    Выведите на экран все положительные делители натурального числа, введённого
    пользователем с клавиатуры.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        // TODO implement
        String sOut = "";
        for ( int j = 1; j <= n; j++ )
          if ( n % j == 0) {
              sOut += (Integer.toString(j) + " ");
          }
        System.out.println(sOut);
    }
}
