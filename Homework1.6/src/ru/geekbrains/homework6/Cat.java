package ru.geekbrains.homework6;

public class Cat extends Animals {

    Cat (String name) {
        super(name, 200, 2.0, 0);
    }

    @Override
    boolean setLengthSwim (int lSwim) {
        System.out.println(name + " не умеет плавать!");
        return false;
    }
}
