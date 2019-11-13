package com.javarush.task.task19.task1908;

import java.io.*;
/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));

        String line = reader1.readLine();
            String[] strings = line.split(" ");
            for (String s : strings) {
                try {
                    String result = Integer.parseInt(s) + " ";
                    writer.write(result);
                }
                catch (Exception c) {

                }
            }

        reader.close();
        reader1.close();
        writer.close();
    }
}
