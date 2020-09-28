import Annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1. Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами методов
 * с аннотациями @Test. Для этого у него должен быть статический метод start(), которому в качестве параметра
 * передается или объект типа Class, или имя класса. Из «класса-теста» вначале должен быть запущен метод с
 * аннотацией @BeforeSuite, если такой имеется, далее запущены методы с аннотациями @Test, а по завершению
 * всех тестов – метод с аннотацией @AfterSuite. К каждому тесту необходимо также добавить приоритеты (int
 * числа от 1 до 10), в соответствии с которыми будет выбираться порядок их выполнения, если приоритет
 * одинаковый, то порядок не имеет значения. Методы с аннотациями @BeforeSuite и @AfterSuite должны
 * присутствовать в единственном экземпляре, иначе необходимо бросить RuntimeException при запуске
 * «тестирования».
 * Это домашнее задание никак не связано с темой тестирования через JUnit и использованием этой библиотеки,
 * то есть проект пишется с нуля.
 *
 * 2. Написать программу для проверки ДЗ
 * (Проанализировать папку с компилированными классами и вызвать методы, проверить результат) Не сделано
 *
 * 3. Написать метод который позволял бы заполнить и вывести на консоль матрицу 4 на 4 (заполненую инкрементом
 * числа, начиная с 1)
 */


public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        run(TestClass.class);
    }


    static void run(Class cls) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = cls.getDeclaredMethods();
        List<Method> list = new ArrayList<>();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                int priority = m.getAnnotation(Test.class).priority();
                if (priority < 1 || priority > 10) throw new RuntimeException("Invalid priority! Priority from 1 to 10.");
                list.add(m);
            }
        }

        list.sort(new Comparator<Method>() {
            @Override
            public int compare(Method m1, Method m2) {
                return m2.getAnnotation(Test.class).priority() - m1.getAnnotation(Test.class).priority();
            }
        });

        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (list.get(0).isAnnotationPresent(BeforeSuite.class)) throw new RuntimeException("BeforeSuite can only use it one time and at the beginning");
                list.add(0, m);
            }
        }

        for (Method m : methods) {
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (list.get(list.size() - 1).isAnnotationPresent(AfterSuite.class)) throw new RuntimeException("AfterSuite can only use it one time and at the end");
                list.add(m);
            }
        }

        for (Method o : list) {
            o.invoke(null);
        }
    }

}
