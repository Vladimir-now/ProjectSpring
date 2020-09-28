package ru.geekbrains.homework7;

public class Cat {
    private String name;
    private int appetite;
//    3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны)
    private boolean satiety = false;

    public Cat (String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (appetite <= p.getFood() && satiety == false) {
            satiety = true;    //Если коту удастся покушать (хватит еды), сытость = true
            p.decreaseFood(appetite);
        } else satiety = false;   //4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт
    }

    public void catInfo () { //Вывод информации о коте в консоль
        System.out.println("Name: " + name + ", appetite: " + appetite);
    }

    public boolean getSatietyInfo () { //Чтение сытости
        return satiety;
    }

}
