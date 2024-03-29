package com.javarush.task.task18.task1822;

import java.io.*;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        reader.close();

        while (fileReader.ready()) {
            String product = fileReader.readLine();
            if (product.startsWith(args[0] + " ")) System.out.println(product);
        }
        fileReader.close();
    }
}