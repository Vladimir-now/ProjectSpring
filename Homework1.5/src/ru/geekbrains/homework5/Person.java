package ru.geekbrains.homework5;

public class Person {

    public Person() {
    }

    /*
    1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    */
    public String fullName;
    public String position;
    public String email;
    public String phoneNumber;
    public int salary;
    public int age;
    /*
    2. Конструктор класса должен заполнять эти поля при создании объекта.
    */
    public Person (String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    /*
    3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    */
    public void printInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: +" + phoneNumber);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age +" лет");
    }
    /*
    4. Создать массив из 5 сотрудников.
                Пример:
                Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
                persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
                persArray[1] = new Person(...);
                ...
                persArray[4] = new Person(...);
        5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
         */

}
