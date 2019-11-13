package com.javarush.task.task18.task1819;

import java.io.*;
/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream fis1 = new FileInputStream(fileName1);
        FileOutputStream fot1 = new FileOutputStream(fileName1);
        FileInputStream fis2 = new FileInputStream(fileName2);

        byte[] buffer = new byte[fis1.available()];
        int count = 0;

        while (fis1.available() > 0) {
            count = fis1.read(buffer);
        }
        byte[] buffer2 = new byte[fis2.available()];
        int count2 = 0;
        while (fis2.available() > 0) {
            count2 = fis2.read(buffer2);

        }
       // byte[] result = new byte[buffer2.length + buffer.length];
        //System.arraycopy(buffer2, 0, result, 0, buffer2.length);
       // System.arraycopy(buffer, 0, result, buffer2.length, buffer.length);
        fis1.close();
        fis2.close();
        fot1.write(buffer2);
        fot1.write(buffer);

        fot1.close();




    }
}
