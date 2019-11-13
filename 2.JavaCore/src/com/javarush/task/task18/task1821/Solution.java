package com.javarush.task.task18.task1821;

import java.io.*;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File(args[0]));
        int[] array = new int[128];
        int count = 0;

        while (fis.available() > 0) {
            int count1 = fis.read();
            for(int i = 0; i < array.length; i++) {
                if (i == count1) count++;
                array[i] += count;
                count = 0;
            }

        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0)
            System.out.println((char) i + " " + array[i]);
        }
        fis.close();

    }
}
