package ru.geekbrains.homework1;

import java.util.Arrays;

public class Homework2 {

    public static void main(String[] args) {
//        System.out.println("Задание 1");
//        invertArray();
//        System.out.println("Задание 2");
//        fillArray();
//        System.out.println("Задание 3");
//        changeArray();
//        System.out.println("Задание 4");
//        fillDiagonal();
//        System.out.println("Задание 5**");
//        searchMinMax();
//        System.out.println("Задание 6**");
//        int[] array = {1, 2, 4, 4, 2, 1};
//        isTrueIfSumLeftAndRightEqual(array);
//        System.out.println("Задание 7****");
//        int[] arr = {1,2,3,4,5};
//        offsetPosition(arr, 3);
//        System.out.println(Arrays.toString(arr));
    }

    // 1. Массив с состоящий из 0 и 1  и изменненный при помощи цикла for и проверки условий в if
    public static void invertArray() {
        int[] array01 = {0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0}; // Объявляем целочисленный массив и инициализируем его
        System.out.print("Изначальный массив: " + Arrays.toString(array01)); // Вывод на экран массива до изменения
        for (int i = 0; i < array01.length; i++) { //Создаем цикл for для проверки каждой ячейки массива с длиной length
            if (array01[i] == 0) { // Проверяем условие
                array01[i] = 1; // Если число в ячейке = 0 присваиваем новое значение = 1
            } else array01[i] = 0; // Если условие не выполняется то присваиваем значение = 0
        }
        System.out.println();
        System.out.println("Новый массив: " + Arrays.toString(array01)); // Вывод на экран массива после изменения
    }

    // 2. Пустой целочисленный массив с длиной 8 и присвоенными значениями [0 3 6 9 12 15 18 21]
    public static void fillArray() {
        int[] array = new int[8]; //Объявляем массив длиной 8
        for (int i = 0; i < array.length; i++) { //Создаем цикл for для инициализации массива с длиной length
            array[i] = i * 3; //Инициализация каждой ячейки массива
            System.out.print(array[i] + " "); //Вывод массива с присвоенными данными
        }
        System.out.println();
    }

    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2
    public static void changeArray() {
        int[] num = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; // Объявяем целочисленный массив и инициализируем его
        for (int i = 0; i < num.length; i++) { //Создаем цикл for для проверки каждой ячейки массива с длиной length
            if (num[i] < 6) { // Проверяем условие ячейки массива
                num[i] = num[i] * 2; // Если не соответствует умножаем на 2
            }
            System.out.print(num[i] + " "); //Вывод массива с новыми значениями
        }
        System.out.println();
    }

    /* 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами.*/
    public static void fillDiagonal() {
        int[][] squareArray = new int[11][11]; //Объявляем двумерный массив с одинаковой длиной
        int number = 1; //Инициалиируем переменную, которая будет записываться по диагонали
        int j = 0; //Инициализируем переменную, для перемещения внитри 2ого массива
        for (int i = 0; i < squareArray.length; i++) { //Создаем цикл для перемещения по диагоналям и инициализации
            squareArray[i][j] = number; //Инициализация ячейки [i][j]
            int x = squareArray[i].length - 1; //Индекс последний ячейки 2ого массива
            squareArray[i][x - j] = number; //Инициализация ячейки [i][x-j], обратная диагональ
            j++; //Приращение переменной j
        }
        for (int i = 0; i < squareArray.length; i++) {    //Вывод двумерного массива
            for (j = 0; j < squareArray[i].length; j++)
                System.out.print(squareArray[i][j] + "  ");
            System.out.println();
        }
    }

    // 5**. Задать одномерный массив и найти в нем минимальный и максимальный элементы
    public static void searchMinMax() {
        int[] arr = new int[10]; //Создаем одномерный массив с длиной 10
        for (int i = 0; i < arr.length; i++) { //Цикл для инициализации массива случайными числами от 1 до 10
            int x = (int) (Math.random() * 10); //Присваиваем целочисленной переменной случайное число от 0 до 10
            arr[i] = x; //Присаиваем элементу массива значение переменной x
        }
        int min, max; // Создаём целочисленные переменные min и max
        min = max = arr[0]; //Инициализируем переменные min и max значению равному первому элементу массива arr
        for (int i = 0; i < arr.length; i++) { // Цикл для поиска min и max значения
            if (arr[i] < min)
                min = arr[i]; // Проверяем условие, если значение переменной min больше значения элемента массива, присваем значение этого элемента
            if (arr[i] > max)
                max = arr[i]; // Проверяем условие, если значение переменной max больше значения элемента массива, присваем значение этого элемента
        }
        System.out.println(Arrays.toString(arr)); //Вывод одномерного массива созданного из случайных чисел
        System.out.println("Минимальное значение:" + min); //Вывод минимального значения
        System.out.println("Максимальное значение:" + max); // Вывод максимального значения
    }

    /* 6**. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
если в массиве есть место, в котором сумма левой и правой части массива равны. */
    public static boolean isTrueIfSumLeftAndRightEqual(int arr[]) {
        if (arr == null)  { //Провееряем условие, чтобы не был передан пустой массив
            return false;
        }
        int sumArr = 0, sumLeft = 0; //Создаем целочисленные переменные
        for (int i = 0; i < arr.length; i++) { //Находим сумму  всех чисел в массиве с помощью цикла for
            sumArr += arr[i];
        }
        if ((sumArr %2 !=0) && (sumArr == 0) ) { // Проверяем условие, если сумма чисел в массиве делится на 2 без остатка, то возможен вариент, где правая и левая части равны
            return false; //Иначе в другом варианте false
        }
        for (int i = 0; i < arr.length; i++) { // Находим сумму в левой части массива
            sumLeft += arr[i];
            if (sumArr == sumLeft*2) { //Проверяем условие, если сумма массива равна удвоенной сумме левой части
                return true; //То возвращаем true
            }
        }
        return false;
    }

        // 7****. Метод смещающий позиции в массиве [1,2,3,4,5]
    public static int[] offsetPosition(int[] arr, int shift) {
        if (shift == 0) return arr; //Если количество смещений равно 0, то возвращааем массив обратно
        if (shift < 0) {  //Проверяем условие, если shift < 0, то сдвиг влево
            shift = shift * (-1); //Меняем знак
            for (int i = 0; i < shift; i++) { //Сдвигаем на заданное количество shift
                int x = arr[0]; //Создаем переменную и кладем в неё значение из первой ячейки
                for (int j = 0; j < arr.length - 1; j++) { //Цикл для свига(копирования) ячейки влево
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = x; //Кладем значение х в последнюю ячейку массива
            }
            return arr; //Возвращаем полученный массив
        } else  { //Проверяем условие, если у нас не shift < 0, то сдвиг вправо
            for (int i = 0; i < shift; i++) { //Сдвигаем на заданное количество shift
                int x = arr[arr.length - 1]; //Создаем переменную и кладем в неё значение из последней ячейки
                for (int j = arr.length - 1; j > 0; j--) { //Цикл для свига(копирования) ячейки вправо
                    arr[j] = arr[j - 1];
                }
                arr[0] = x; //Кладем значение х в первую ячейку массива
            }
            return arr; //Возвращаем полученный массив
        }
    }
}