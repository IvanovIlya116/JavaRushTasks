package com.javarush.task.task19.task1906;

import java.io.*;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String result = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName);
        FileWriter fileWriter = new FileWriter(result);
        int count = 1;

        while (fileReader.ready()) {
            int data = fileReader.read();

            if (count % 2 == 0) {fileWriter.write(data);}
            count++;


        }

        fileReader.close();
        fileWriter.close();
    }
}
