package ru.geekbrains.homework3;

import java.util.Scanner;

public class Homework3 {

    public static void main(String[] args) {

        System.out.println("Задание 1.");
        guessTheNumber();

        System.out.println("Задание 2*");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};
        guessTheWord(words);

    }

//        1. Написать программу, которая загадывает случайное число от 0 до 9,
//        и пользователю дается 3 попытки угадать это число.
//        При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
//        После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    static void guessTheNumber() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Угадай число от 0 до 9:");
            int secretNumber = (int) (Math.random() * 10);
            int count = 0;
            int number = -1;
            while (count < 3) {
                System.out.println("Осталось попыток: " + (3 - count));
                number = scanner.nextInt();
                if (number == secretNumber) {
                    break;
                } else if (number < secretNumber) {
                    System.out.println("Загаданное число больше!");
                } else {
                    System.out.println("Загаданное число меньше!");
                }
                count++;
            }
            System.out.println("Вы " + ((secretNumber == number) ? "выиграли!" : "проиграли!") + " Было загадано число:" + secretNumber);
            System.out.println("Повторить игру еще раз?: Да - 1, Нет - 0");
        } while (scanner.nextInt() == 1);
    }

//        2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
//        "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
//        "pear", "pepper", "pineapple", "pumpkin", "potato"};
//        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//        сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
//        Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
//        apple – загаданное
//        apricot - ответ игрока
//        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//        Для сравнения двух слов посимвольно, можно пользоваться:
//        String str = "apple";
//        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//        Играем до тех пор, пока игрок не отгадает слово (сделал 3 попытки)
//        Используем только маленькие буквы

    static void guessTheWord(String[] words) {
        Scanner scanner = new Scanner(System.in);
        do {
            int i = (int) (Math.random() * words.length);
            int j = 0;
            String inputWord = null;
            while (j < 3) {
                char[] symbols = words[i].toCharArray();
                if (words[i].length() < 4) {
                    System.out.println("Угадай загаданное слово: " + symbols[0] + symbols[1] + "#############");
                } else {
                    System.out.println("Угадай загаданное слово: " + symbols[0] + symbols[1] + symbols[2] + "#############");
                }
                System.out.println("Осталось попыток: " + (3 - j));
                inputWord = scanner.next();
                if (inputWord.equals(words[i])) {
                    break;
                } else {
                    System.out.println("Попробуйте еще раз!");
                }
                j++;
            }
            System.out.println("Вы " + (inputWord.equals(words[i]) ? "выиграли!" : "проиграли!") + " Было загадано слово: " + words[i]);
            System.out.println("Повторить игру еще раз?: Да - 1, Нет - 0");
        } while (scanner.nextInt() == 1);
    }
}