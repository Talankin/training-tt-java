package com.dtalankin;

/**
 * 29.09.2015
 * Dmitry Talankin
 * lesson #3
 */
abstract class Fruit { // нельзя создавать его экземпляры
    private int weight;
    protected int volume; // доступно только в данном классе и у всех наследников

    abstract public int getVolue();

    public int getWeight() {
        return weight;
    }

}

class Apple extends Fruit {

    @Override
    public int getVolue() { //либо переопределить метод либо сделать абстрактный методм, но тогда класс станет тоже абстрактным.
        return 0;
    }
}
