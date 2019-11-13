package com.javarush.task.task19.task1926;

import java.io.*;


/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            StringBuffer buffer = new StringBuffer(line);
            buffer.reverse();
            System.out.println(buffer);
        }
        fileReader.close();
    }
}
