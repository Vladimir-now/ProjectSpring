package Lesson2.Exceptions;


import Lesson2.Exceptions.Enum.DayOfWeek;
import Lesson2.Exceptions.Enum.WorkHours;
import Lesson2.Exceptions.Exceptions.ExceptionHandling;
import Lesson2.Exceptions.Exceptions.MyArrayDataException;
import Lesson2.Exceptions.Exceptions.MyArraySizeException;


/**
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого размера
 * необходимо бросить исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе массива
 * преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException,
 * с детализацией в какой именно ячейке лежат неверные данные.
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException,
 * и вывести результат расчета.
 * 4. Требуется реализовать enum DayOfWeek, который будет представлять дни недели.
 * С его помощью необходимо решить задачу определения кол-ва рабочих часов до конца недели по заднному текущему дню.
 *
 * Возвращает кол-во оставшихся рабочих часов до конца
 * недели по заданному текущему дню. Считается, что
 * текущий день ещё не начался, и рабочие часы за него
 * должны учитываться.
 *
 * public class DayOfWeekMain {
 *
 * public static void main(final String[] args) {
 * System.out.println(getWorkingHours(DayOfWeek.MONDAY));
 * }
 */

public class Main {

    public static void main(String[] args) {

//        Task 1-3
        String[][] mass = new String[][] {
                {"1","2","3","4"},
                {"5","m","6","7"},
                {"8","1","9","1"},
                {"1","3","4","2"}
        };
        ExceptionHandling handling = new ExceptionHandling();
        try {
            handling.createIntArraySize4(mass);
        } catch (MyArraySizeException a) {
            a.printStackTrace();
        } catch (MyArrayDataException b) {
            b.printStackTrace();
            System.out.println("Сумма элементов массива с обработкой исключения: " + b.getNum());
        }
        System.out.println();

//        Task 4
        System.out.println(WorkHours.getWorkingHours(DayOfWeek.TUESDAY));
    }
}
