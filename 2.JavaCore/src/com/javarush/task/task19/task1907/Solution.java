package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));
        String line;
        int count = 0;
        while ((line = fReader.readLine()) != null) {
            line = line.toLowerCase();
            line = line.replaceAll("[\\p{P}]", " ");
            String[] arr = line.split(" ");
            for (String s : arr) {
                if (s.equals("world")) {
                    count++;
                }
            }
        }
        fReader.close();
        System.out.println(count);
    }
}