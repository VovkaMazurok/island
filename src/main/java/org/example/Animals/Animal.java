package org.example.Animals;

import org.example.Entity.Characteristics;

public abstract class Animal {
    private double weight;
    private int maxCount;
    private int speed;
    private double foodNeeded;

    public Animal(Characteristics characteristics) {
        this.weight = characteristics.getWeight();
        this.maxCount = characteristics.getMaxCount();
        this.speed = characteristics.getSpeed();
        this.foodNeeded = characteristics.getFoodNeeded();
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxCount() {
        return maxCount;
    }
    public int getSpeed() {
        return speed;
    }

    public double getFoodNeeded() {
        return foodNeeded;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "weight=" + weight +
                ", maxCount=" + maxCount +
                ", speed=" + speed +
                ", foodNeeded=" + foodNeeded +
                '}';
    }
}
