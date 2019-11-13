package com.javarush.task.task18.task1807;

import java.io.*;


/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        int count = 0;
        while (inputStream.available() > 0) {
            if (inputStream.read() == ',') count++;

        }
        System.out.println(count);
        inputStream.close();

    }
}
