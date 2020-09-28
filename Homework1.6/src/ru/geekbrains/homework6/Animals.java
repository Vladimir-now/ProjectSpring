package ru.geekbrains.homework6;

public abstract class Animals {
    String name;
    private int lengthRun;
    private int lengthRunMax;
    private double heightJump;
    private double heightJumpMax;
    private int lengthSwim;
    private int lengthSwimMax;


    Animals (String name, int lengthRunMax, double heightJumpMax, int lengthSwimMax ) {
        this.name = name;
        this.lengthRunMax = lengthRunMax;
        this.heightJumpMax = heightJumpMax;
        this.lengthSwimMax = lengthSwimMax;
    }



    boolean setLengthRun (int l) {
        if (l <= lengthRunMax) {
            lengthRun = l;
            System.out.println(name + " пробежал(а) " + lengthRun + " метр(ов)." );
            System.out.println("Run: " + (l <= lengthRunMax));
            return true;
        } else {
            System.out.println(name + " не может пробежать больше " + lengthRunMax + " метров!");
            System.out.println("Run: " + (l <= lengthRunMax));
            return false;
        }
    }
    int getLengthRun() {
        return lengthRun;
    }

    boolean setHeightJump (double h) {
        if (h <= heightJumpMax) {
            heightJump = h;
            System.out.println(name + " прыгнул(а) на высоту " + heightJump + " метр(а)." );
            System.out.println("Jump: " + (h <= heightJumpMax));
            return true;
        } else {
            System.out.println(name + " не может прыгать выше " + heightJumpMax + " метров!");
            System.out.println("Jump: " + (h <= heightJumpMax));
            return false;
        }
    }
    double getHeightJump(double v) {
        return heightJump;
    }

    boolean setLengthSwim (int lSwim) {
        if (lSwim <= lengthSwimMax) {
            lengthSwim = lSwim;
            System.out.println(name + " проплыл(а) " + lengthSwim + " метр(ов)." );
            System.out.println("Swim: " +(lSwim <= lengthSwimMax));
            return true;
        } else {
            System.out.println(name + " не может проплыть больше " + lengthSwimMax + " метров!");
            System.out.println("Swim: " + (lSwim <= lengthSwimMax));
            return false;
        }
    }

}
