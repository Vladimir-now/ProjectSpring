package ru.geekbrains.homework1;

public class Homework1 {
    // 1.Метод main
    public static void main(String[] args) {
        // 2. Типы переменых
        // Простые boolean и char
        boolean cond = true;
        char sbl = 'f';
        // Целочисленные
        byte a = 127;
        short b = 2323;
        int c = 11234;
        long d = 12345678;
        // С плавающей точкой
        float e = 121.23f;
        double f = 2121.231344;
        // Сложные типы переменных
        // Строчная
        String txt = "Здесь могла быть ваша реклама!";
        // Ну и ссылочные которые изучим позже

    }
    // 3.Метод вычисляющий выражение a * (b + (c / d)) с параметрами a, b, c ,d и возвращающий значение
    public static double calk (double a, double b, double c, double d) {
        double rez = a * (b + (c / d));
        return rez;
    }

    // 4.Метод с двумя входными параметрами и проверяющий условие
    public static boolean cycle (int first, int second ) {
        int rezSum = first + second;
        boolean rezTrueOrFalse = rezSum > 10 && rezSum <= 20;
        return  rezTrueOrFalse;
    }

    // 5.Метод с целочисленным параметром сообщающий знак входного числа
    public static void number (int num) {
        if (num >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    // 6.Метод передает значение true если параметр отрицательный
    public static boolean trueIfNegative (int neg) {
        boolean rezult = neg < 0;
        return rezult;
    }

    //7.Метод выводящий текст + строчный параметр
    public static void helloName (String name) {
        System.out.println("Привет, " + name + "!");
    }

    //8*.Метод отпределяющий "високосный" ли год и выводящий текст на экран
    public static void ifLeapYear (int year) {
        if ((year %4) == 0 && (year %100) > 0 || (year %400) == 0) {
            System.out.println(year + " - это високосный год!");
        } else {
            System.out.println(year + " - этот год не високосный!");
        }
    }


}
