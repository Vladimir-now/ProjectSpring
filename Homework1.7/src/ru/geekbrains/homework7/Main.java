package ru.geekbrains.homework7;

import java.util.Random;

public class Main {

//    1. Расширить задачу про котов и тарелки с едой
//    2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды,
//    а кот пытается покушать 15-20)
//    3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды),
//    сытость = true
//    4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это
//    сделано для упрощения логики программы)
//    5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о
//    сытости котов в консоль
//    6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку

    public static void main(String[] args) {
//    5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о
//    сытости котов в консоль
        Cat[] cats = new Cat[5];
        Plate plate = new Plate(30);
        createCats(cats);
        plate.info();
        for (int i = 0; i < cats.length; i++) { //Каждый кот по очереди ест из одной миски
            cats[i].eat(plate);
        }
        print(cats);
        plate.info();
    }

//      Создание массива котов со случайными именами и разным аппетитом
    static void createCats(Cat[] cats) {
        String[] names = {"Barsik","Murzik","Max", "Kesha", "Gosha", "Misha", "Cezar", "Kitty", "Symon", "Archi", "Mikky",
        "Bella", "Lydvig", "Mitty", "Billy", "Lew", "Rizik"};
        Random random = new Random();
        Random appetite = new Random();
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat(names[random.nextInt(names.length)], appetite.nextInt(21));
        }
    }

//Печать информации о каждом коте
     static void print (Cat[] cats) {
        for (int i = 0; i < cats.length; i++) {
            cats[i].catInfo();
            System.out.println("Satiety: " + cats[i].getSatietyInfo());
        }
    }
}
