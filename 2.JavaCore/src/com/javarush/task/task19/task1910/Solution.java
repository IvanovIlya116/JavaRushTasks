package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));

        String data = fileReader.readLine();
        //Pattern pattern = Pattern.compile("[^\\d|\\w|\\s]+");
        //Matcher matcher = pattern.matcher(data);
        String newData = data.replaceAll("\\p{Punct}|\\n","");
        fileWriter.write(newData);

        fileReader.close();
        fileWriter.close();
    }
}
