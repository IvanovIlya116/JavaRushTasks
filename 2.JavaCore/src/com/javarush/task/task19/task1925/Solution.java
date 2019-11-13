package com.javarush.task.task19.task1925;

import  java.io.*;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        String line;
        String result = "";

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(" ");
            for (String s : data) {
                if (s.length() > 6) result += s + ",";
            }
        }

        writer.write(result.substring(0, result.length() - 1));

        reader.close();
        writer.close();

    }
}
