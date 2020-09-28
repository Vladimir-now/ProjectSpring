package Lesson3.Collections;

import java.util.ArrayList;
import java.util.HashMap;

/**
  * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник с
  * помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией
  * может быть несколько телефонов, тогда при запросе такой фамилии должны выводиться все телефоны.
  *
  * Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя,
  * отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.). Консоль желательно не использовать (в том числе Scanner),
  * тестировать просто из метода main() прописывая add() и get().
  */

public class PhoneBook {

    private HashMap<String, ArrayList<String>> bookLines;

    public PhoneBook() {
        this.bookLines = new HashMap<>();
    }


    public void add (String surname, String phoneNumber) {
        ArrayList<String> arrayList = bookLines.getOrDefault(surname, new ArrayList<>());
        arrayList.add(phoneNumber);
        bookLines.put(surname, arrayList);
    }

    public void get (String surname) {
        if (bookLines.containsKey(surname)) {
            System.out.println(surname + " тел. " + bookLines.get(surname));
        } else {
            System.out.println(surname + "a(-voj) нет в списке!");
        }
    }
}
