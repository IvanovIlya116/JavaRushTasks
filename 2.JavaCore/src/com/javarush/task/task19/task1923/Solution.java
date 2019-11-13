package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(" ");
            for (String string : data) {
                if (!string.replaceAll("\\d","").equals(string)) {
                    writer.write(string + " ");
                }
            }
        }
        reader.close();
        writer.close();
    }
}
