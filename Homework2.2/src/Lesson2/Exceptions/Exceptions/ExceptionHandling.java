package Lesson2.Exceptions.Exceptions;

public class ExceptionHandling {

    public void createIntArraySize4(String[][] array) throws MyArraySizeException, MyArrayDataException {

//        Вброс исключения MyArraySizeException
        if (array.length == 4) {
            for (String[] s : array) {
                if (s.length != 4) {
                    throw new MyArraySizeException("Двумерный массив должен быть размером 4х4");
                }
            }
        } else {
            throw new MyArraySizeException("Двумерный массив должен быть размером 4х4");
        }

//        Вброс исключения MyArrayDataException
        int result = 0;
        int x = 0;
        int y = 0;
        boolean exception = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int number;
                try {
                    number = Integer.parseInt(array[i][j]);
                } catch (NumberFormatException a) {
                    number = 0;
                    exception = true;
                    x = i;
                    y = j;
                }
                result += number;
            }
        }
        if (exception) throw new MyArrayDataException("В ячейке [" + x + "][" + y + "] не лежит число!" , result);

        System.out.println("Сумма элементов массива: " + result);
    }
}
