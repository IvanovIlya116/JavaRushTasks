package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.regex.*;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));

        String data = fileReader.readLine();
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(data);
        String newData = matcher.replaceAll("!");
        fileWriter.write(newData);

        fileReader.close();
        fileWriter.close();
    }
}
