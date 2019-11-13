package com.javarush.task.task06.task0605;


import java.io.*;

/* 
Контролируем массу тела
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.calculateMassIndex(weight, height);
    }

    public static class Body {
        public static void calculateMassIndex(double weight, double height) {
            double indexOfBody = weight / (height * height);

            if (indexOfBody < 18.5) {
                System.out.println("Недовес: меньше чем 18.5");
            }

            if (indexOfBody >= 18.5 && indexOfBody < 25) {
                System.out.println("Нормальный: между 18.5 и 24.9");
            }

            if (indexOfBody >= 25 && indexOfBody < 30) {
                System.out.println("Избыточный вес: между 25 и 29.9");
            }

            if (indexOfBody >= 30) {
                System.out.println("Ожирение: 30 или больше");
            }
        }
    }
}
