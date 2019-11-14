package com.ifmo.lesson2;

import java.util.Random;

public class IsInInterval {
    /*
     Создать программу, которая будет проверять попало ли случайно выбранное из отрезка
    [5;155] целое число в интервал (25;100) и сообщать результат на экран.Примеры работы
    программы:
    Число 113 не содержится в интервале (25,100) Число 72 содержится в интервале (25,100) 
    Число 25 не содержится в интервале (25,100) Число 155 не содержится в интервале (25,100) 
     */
    public static void main(String[] args) {
        int rnd = randomInt();

        String inInterval = isInInterval(rnd);

        // TODO implement

        System.out.printf("число %d %s содержится в интервале", rnd, inInterval);

    }

    public static int randomInt() {
        // TODO implement
        Random r = new Random();
        return r.nextInt(150) + 5;
    }

    public static String isInInterval(int rnd) {
        // TODO implement
        return (( ( rnd < 26 ) || ( rnd > 99 ) ) ? "не" : "");
    }

}
