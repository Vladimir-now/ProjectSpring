package Generalizations;


/**
 * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
 * 2. Написать метод, который преобразует массив в ArrayList;
 * 3. Большая задача:
 *      a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
 *      b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 *      c. Для хранения фруктов внутри коробки можете использовать ArrayList;
 *      d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
 *      e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
 *      f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
 *      g. Не забываем про метод добавления фрукта в коробку.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        Task 1
        Character[] mass1 = new Character[10];
        char ch = 'a';
        for (int i = 0; i < mass1.length ; i++) {
            mass1[i] = ch;
            ch++;
        }
        System.out.println(Arrays.toString(mass1));
        try {
            swap(mass1, 0,9);
            System.out.println(Arrays.toString(mass1));
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }


//        Task 2
        Integer[] mass2 = new Integer[10];
        for (int i = 0; i <mass2.length; i++) {
            mass2[i] = i;
        }
        System.out.println(Arrays.toString(mass2));
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        convertArrToArrayList(mass2,arrayList2);
        for (int i = 0; i < arrayList2.size() ; i++) {
            System.out.print(arrayList2.get(i) + " ");
        }
        System.out.println();

//        Task 3
        Box<Apple> withApples = new Box<Apple>();
        withApples.addFruit(new Apple(), 30);
        Box<Orange> withOranges = new Box<Orange>();
        withOranges.addFruit(new Orange(), 20);

        System.out.println("Вес коробки с яблоками: " + withApples.getWeight());
        System.out.println("Вес коробки с апельсинами: " + withOranges.getWeight());
        System.out.println("Вес у коробок одинаковый? : " + withApples.compare(withOranges));

        Box<Apple> withApples2 = new Box<Apple>();
        System.out.println("Вес 2 коробки с яблоками: " + withApples2.getWeight());

        withApples.pourInto(withApples2);
        System.out.println("Вес 2 коробки с яблоками после пересыпки: " + withApples2.getWeight());
        System.out.println("Вес 1 коробки с яблоками после пересыпки в новую коробку: " + withApples.getWeight());


    }


    /**
     * Метод, который меняет два элемента массива местами.
     */
    static void swap(Object[] obj, int firstIndex, int secondIndex) throws ArrayIndexOutOfBoundsException {
        if (firstIndex < 0 || firstIndex > obj.length || secondIndex < 0 || secondIndex > obj.length) {
            throw new ArrayIndexOutOfBoundsException("Введены индексы за пределами массива!" + "\n" + "Значения могут быть от 0 до " + (obj.length - 1) + ".");
        }
        Object x = obj[firstIndex];
        obj[firstIndex] = obj[secondIndex];
        obj[secondIndex] = x;
    }

        /**
         * Метод, который преобразует массив в ArrayList;
         */
    static ArrayList convertArrToArrayList(Object[]obj, ArrayList<Object> arrayList){
        for (int i = 0; i < obj.length; i++) {
            arrayList.add(obj[i]);
        }
        return arrayList;
    }

}
