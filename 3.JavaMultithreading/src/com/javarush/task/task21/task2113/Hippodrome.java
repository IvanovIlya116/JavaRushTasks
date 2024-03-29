package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public List<Horse> getHorses() {
        return horses;
    }

    private static List<Horse> horses;
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        horses = new ArrayList<>();


        horses.add(new Horse("horse1", 3, 0));
        horses.add(new Horse("horse2", 3, 0));
        horses.add(new Horse("horse3", 3, 0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();


    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move() {
        for (Horse horse: horses) horse.move();

    }
    public void print() {
        for (Horse horse : horses) horse.print();
        for (int i = 0; i < 10; i++) System.out.println();

    }

    public Horse getWinner() {
        int max = 0;
        Horse winner = null;
        for (Horse horse : horses) {
            if (horse.getDistance() > max) max = (int) horse.getDistance();
        }
        for (Horse horse : horses) {
            if ((int) horse.getDistance() == max) winner = horse;
        }
        return winner;

    }
    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");


    }
}
