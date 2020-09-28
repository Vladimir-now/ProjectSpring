package ru.geekbrains.homework4;

import java.util.Random;
import java.util.Scanner;

public class Homework4 {
    public static char[][] map;
    public static final int SIZE = 3;
    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurnBlock();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил компьютер!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    //Создание игрового поля
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    //Вывод поля в консоль
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

    //Ход человека
    public static Scanner scanner = new Scanner(System.in);
    public static void humanTurn() {
        int x = -1, y = -1;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    //Проверка хода
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    //Ход компьютера
    public static Random rand = new Random();
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьтер сходил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    //Ход компьютера 2.0
    public static void aiTurnBlock() {
        int x = 0, y = 0;
        boolean userWin = false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)) {
                        x = i;
                        y = j;
                        userWin = true;
                    } else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }

        if (!userWin) {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
        }
        System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }


    //Проверка победы
    public static boolean checkWin(char symb) {

        //Проверка по горизонтали и вертикали
        for (int i = 0; i < SIZE; i++) {
            int j = 0;
            while (map[i][j] == symb || map[j][i] == symb) {
                if (j == (SIZE - 1)) return true;
                j++;
            }
        }

        //Проверка по диагонали
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == symb) {
                if (map[SIZE - 1][SIZE - 1] == symb && i == (SIZE-1)) return true;
            } else break;
        }
        //Проверка по обратной диагонали
        for (int i = 0; i < SIZE; i++) {
            if (map[SIZE - 1 - i][i] == symb) {
                if (map[0][i] == symb && i == (SIZE-1)) return true;
            } else break;
        }
        return false;
    }

    //Если карта полная
    public static boolean isMapFull () {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map [i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
}


