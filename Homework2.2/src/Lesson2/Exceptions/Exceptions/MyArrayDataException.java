package Lesson2.Exceptions.Exceptions;

public class MyArrayDataException extends Exception {

    private int num;

    public MyArrayDataException(String message, int number) {
        super(message);
        num = number;
    }

    public int getNum() {
        return num;
    }
}
