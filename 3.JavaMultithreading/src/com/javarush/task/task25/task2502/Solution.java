package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            wheels = new ArrayList<>();
            String[] dataFromMethod = loadWheelNamesFromDB();
           if (dataFromMethod.length != 4) throw new IllegalArgumentException();

           for (int i = 0; i < dataFromMethod.length; i++) {
                wheels.add(Wheel.valueOf(dataFromMethod[i]));
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        for (Wheel wheel : new Car().wheels) {
            System.out.println(wheel);
        }
    }
}
