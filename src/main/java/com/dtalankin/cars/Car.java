/**
 *     23.10.2015
 *     Dmitry Talankin
 *     Lessons #3 Task #12
 */

package com.dtalankin.cars;

import com.dtalankin.Color;
import com.dtalankin.Colored;
import com.dtalankin.exceptions.ColorException;

public class Car implements Colored {
    private String brand;
    private int weight;
    private int maxSpeed;
    private Color color;

    public Car(String brand, int weight, int maxSpeed, Color color) {
        this.brand = brand;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    public Car(String brand, int weight, int maxSpeed, String color) throws ColorException {
        this.brand = brand;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.color = Color.colorStr(color);
    }

    public Car(String brand, int weight, int maxSpeed) {
        this.brand = brand;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.color = Color.WHITE;
    }

    public void print () {
        System.out.println("Car:   brand = " + brand + ";  weight = " + weight + "; maxSpeed = " + maxSpeed + ";  color = " + color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (getWeight() != car.getWeight()) return false;
        if (getMaxSpeed() != car.getMaxSpeed()) return false;
        return !(getBrand() != null ? !getBrand().equals(car.getBrand()) : car.getBrand() != null);

    }

    @Override
    public int hashCode() {
        int result = getBrand() != null ? getBrand().hashCode() : 0;
        result = 31 * result + getWeight();
        result = 31 * result + getMaxSpeed();
        return result;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

}
