package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.io.*;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int min = Integer.MAX_VALUE;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (min > data) min = data;

        }
        System.out.println(min);
        reader.close();
        inputStream.close();
    }
}
