package org.example.Entity;

public class Characteristics {


    private double weight;
    private int maxCount;
    private int speed;
    private double foodNeeded;

    public Characteristics() {

    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getFoodNeeded() {
        return foodNeeded;
    }

    public void setFoodNeeded(double foodNeeded) {
        this.foodNeeded = foodNeeded;
    }

    public Characteristics(double weight, int maxCount, int speed, double foodNeeded) {
        this.weight = weight;
        this.maxCount = maxCount;
        this.speed = speed;
        this.foodNeeded = foodNeeded;
    }

    @Override
    public String toString() {
        return "Characteristics[weight=" +
                weight + ", maxCount=" +
                maxCount + ", speed=" +
                speed + ", foodNeeded=" +
                foodNeeded + "]";
    }

}
