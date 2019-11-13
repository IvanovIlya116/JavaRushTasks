package com.javarush.task.task18.task1826;

import java.io.*;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[1];
        String fileOutputName = args[2];
        FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutputName);
        byte[] buffer = new byte[fis.available()];
        int count = 0;

        switch (args[0]) {

            case "-e": {

                while (fis.available() > 0) {
                    count = fis.read(buffer);

                }
                for (int i = 0; i < buffer.length; i++) buffer[i] -= 5;
                fos.write(buffer, 0, count);
                break;

            }

            case"-d": {
                while (fis.available() > 0) {
                    count = fis.read(buffer);

                }
                for (int i = 0; i < buffer.length; i++) buffer[i] += 5;
                fos.write(buffer, 0, count);
                break;

            }
        }
        fis.close();
        fos.close();


    }

}
