package com.ifmo.lesson2;

public class WallClock {
    /*
    На некотором предприятии инженер Петров создал устройство, на табло которого
    показывается количество секунд, оставшихся до конца рабочего дня. Когда рабочий день
    начинается ровно в 9 часов утра — табло отображает «28800» (т.е. остаётся 8 часов), когда
    времени 14:30 — на табло «9000» (т.е. остаётся два с половиной часа), а когда наступает 17
    часов — на табло отображается «0» (т.е. рабочий день закончился).Программист Иванов
    заметил, как страдают офисные сотрудницы — им неудобно оценивать остаток рабочего дня
    в секундах. Иванов вызвался помочь сотрудницам и написать программу, которая вместо
    секунд будет выводить на табло понятные фразы с информацией о том, сколько полных часов
    осталось до конца рабочего дня. Например: «осталось 7 часов», «осталось 4 часа», «остался
    1 час», «осталось менее часа».Итак, в переменную n должно записываться случайное (на
    время тестирования программы) целое число из [0;28800], далее оно должно выводиться на
    экран (для Петрова) и на следующей строке (для сотрудниц) должна выводиться фраза о
    количестве полных часов, содержащихся в n секундах.

    Примеры работы программы:
    23466
    Осталось 6 часов

    10644
    Осталось 2 часа

    5891
    Остался 1 час

    1249
    Осталось менее часа
     */
    public static void main(String[] args) {
        int randomSecond = randomSecond();

        String remainingHours = remainingHours(randomSecond);

        System.out.println(remainingHours);
    }

    public static int randomSecond() {
        // TODO implement

        return 0;
    }

    public static String remainingHours(int rndSecond) {
        // TODO implement

        return "Осталось менее часа";
    }
}
