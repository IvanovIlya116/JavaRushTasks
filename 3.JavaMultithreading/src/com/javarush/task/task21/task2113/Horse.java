package com.javarush.task.task21.task2113;

public class Horse {
    private String name;
    private double speed;
    private double distance;


    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move() {
        distance += speed * (Math.random() * 1.0);



    }

    public void print() {
        int horseResult = (int) distance;
        for (int i = 0; i < horseResult; i++) System.out.print(".");
        System.out.print(this.getName());
        System.out.println();

    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
