package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File(args[0]));
        double countOfSpaces = 0;
        double countOfSymbols = 0;
        double ratioOfNumbers;

        while (fis.available() > 0) {
            if (fis.read() == ' ') countOfSpaces++;
            else countOfSymbols++;
        }
        ratioOfNumbers = (double) Math.round(countOfSpaces / (countOfSpaces +countOfSymbols) * 100 * 100.0) / 100.0;
        System.out.println(ratioOfNumbers);
        fis.close();

    }
}
