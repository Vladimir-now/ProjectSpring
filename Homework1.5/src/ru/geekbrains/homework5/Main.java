package ru.geekbrains.homework5;

import sun.awt.windows.WPrinterJob;

public class Main {

    /*
    1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    2. Конструктор класса должен заполнять эти поля при создании объекта.
    3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    4. Создать массив из 5 сотрудников.
                Пример:
                Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
                persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
                persArray[1] = new Person(...);
                ...
                persArray[4] = new Person(...);
    5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
     */


    public static void main(String[] args) {

//        4. Создать массив из 5 сотрудников.
//                Пример:
//                Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//                persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
//                persArray[1] = new Person(...);
//                        ...
//                persArray[4] = new Person(...);

        Person[] personArray = new Person[5];
        personArray[0] = new Person("Иванов Иван Иванович", "Уборщик", "ivanovii@mail.ru", "79854551122", 15000, 45);
        personArray[1] = new Person("Петров Петр Петрович", "Менеджер", "perovpetro@mail.ru", "79154567891", 35000, 34);
        personArray[2] = new Person("Васильев Василий Васильевич", "Управляющий", "vasilyevvv@mail.ru", "79164125378", 50000, 51);
        personArray[3] = new Person("Александрова Александра Александровна", "Бухгалтер", "alexis@mail.ru", "79152223355", 32000, 59);
        personArray[4] = new Person("Геннадьев Геннадий Геннадьевич", "Менеджер по подбору персонала", "genius@mail.ru", "79648561234", 30000, 39);

        printFromList(personArray);

    }


//  5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
    static void printFromList (Person[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].age >= 40) {
                arr[i].printInfo();
                System.out.println();
            }
        }
    }
}
