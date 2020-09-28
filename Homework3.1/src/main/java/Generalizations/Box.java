package Generalizations;

import java.util.ArrayList;

public class Box <F extends Fruit> {

    private float weight;
    private ArrayList<F> fruit = new ArrayList<F>();

    /**
     * Метод, который высчитывает вес коробки
     */
    public float getWeight() {
        if (fruit.size() == 0) {
            return 0.0f;
        }
        for (int i = 0; i < fruit.size(); i++) {
            weight += fruit.get(i).getWeight();
        }
       return weight;
    }

    /**
     * Метод, сравнивает вес коробок
     */
    public boolean compare(Box<?> otherBox) {
        if ((this.weight - otherBox.weight) < 0.00001) {
            return true;
        }
        return false;
    }

    public void pourInto(Box<F> otherBox) {
        otherBox.fruit.addAll(this.fruit);
        this.fruit.clear();
    }

    /**
     *Метод добавления фруктов в коробку
     */
    public void addFruit(F oneFruit, int num) {
        for (int i = 0; i < num; i++) {
            fruit.add(oneFruit);
        }
    }

}
