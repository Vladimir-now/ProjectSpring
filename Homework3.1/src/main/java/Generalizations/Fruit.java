package Generalizations;

abstract class Fruit {
    private float weight;

    Fruit(float weight){
        this.weight = weight;
    }
    public float getWeight() {
        return weight;
    }
}

class Apple extends Fruit{

    Apple() {
        super( 1.0f);
    }
}

class Orange extends Fruit {

    Orange(){
        super( 1.5f);
    }
}