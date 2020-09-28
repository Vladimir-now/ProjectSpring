import java.util.Arrays;

/**
 * 1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
 * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
 * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
 * необходимо выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных
 * данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 *
 * 2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки
 * или единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
*/


public class Tasks {


    public int[] task1(int[] arr) {
        int[] result = null;
        boolean foundFour = false;
        int forNewArr = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (foundFour = arr[i] == 4) {
                break;
            }
            forNewArr = i;
        }
        if (foundFour) {
            result = new int[arr.length - forNewArr];
            for (int a = 0; a < result.length; a++) {
                result[a] = arr[forNewArr + a];
            }
        } else {
            throw new RuntimeException("In array not found number 4");
        }
        return result;
    }

    public boolean task2(int[] arr) {
        boolean foundOne = false;
        boolean foundFour = false;
        for (int x : arr) {
           if (x == 1) {
               foundOne = true;
           }
           if (x == 4) {
               foundFour = true;
           }
        }
        if (foundOne & foundFour) {
            return true;
        } else {
            return false;
        }
    }
}
