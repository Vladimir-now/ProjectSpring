package ru.geekbrains.homework7;

public class Plate {
    private int food;

    public Plate (int food) {
        this.food = food;
    }

//    2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды,
//    а кот пытается покушать 15-20)
    public void setFood (int f) { //Редактирование с условием параметра food
        if (f < 0) {
            System.out.println("В миске не осталось еды!");
            food = 0;
        } else food = f;
    }
    public int getFood() { //Чтение параметра food
        return food;
    }

    public void decreaseFood (int n) { //Уменьшение еды в миске
        setFood(food);
        food -= n;
    }

//    6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    public void increaseFood (int n) { //Увеличение еды в миске
        food += n;
    }
    public void info() { //Сколько в миске еды
        System.out.println("В миске еды: " + getFood());
    }
}
