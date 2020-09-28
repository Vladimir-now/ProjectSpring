package Lesson3.Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать сколько раз встречается каждое слово.
 * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник с
 * помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией
 * может быть несколько телефонов, тогда при запросе такой фамилии должны выводиться все телефоны.
 *
 * Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя,
 * отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.). Консоль желательно не использовать (в том числе Scanner),
 * тестировать просто из метода main() прописывая add() и get().
 */

public class Main {

    public static void main(String[] args) {

//        Task 1
        String[] cities = {"Москва", "Рязань", "Челябинск", "Астрахань", "Казань", "Астана", "Белгород", "Нижний Новгород", "Саров"};
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(cities[(int) (Math.random()*cities.length)]);
        }
        System.out.println(arrayList);

        uniqueWords(arrayList);
        oneArray(arrayList);

        System.out.println();

//        Task 2
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Vasilev", "79158524565");
        phoneBook.add("Vasilev", "79254861223");
        phoneBook.add("Vasilev", "79167892558");
        phoneBook.add("Sidorov", "79157894565");
        phoneBook.add("Petrov", "79158142563");
        phoneBook.add("Ivanov", "79178954565");
        phoneBook.add("Ivanov", "79254759561");

        phoneBook.get("Vasilev");
        phoneBook.get("Sidorov");
        phoneBook.get("Petrov");
        phoneBook.get("Ivanov");
        phoneBook.get("Degtyarev");

    }

    public static void uniqueWords(ArrayList<String> arrayList) {
        HashSet<String> hashSet = new HashSet<>();
        for (String word : arrayList) {
            hashSet.add(word);
        }
        System.out.println(hashSet);
    }

    public static void oneArray (ArrayList<String> arrayList) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            Integer res = hashMap.get(arrayList.get(i));
            hashMap.put(arrayList.get(i), res == null ? 1 : res + 1);
        }
        System.out.println(hashMap);
    }
}
