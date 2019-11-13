package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        FileOutputStream fot1 = new FileOutputStream(fileName1);
        FileInputStream fis2 = new FileInputStream(fileName2);
        FileInputStream fis3 = new FileInputStream(fileName3);

        byte[] buffer = new byte[fis2.available()];
        int count = 0;
        while (fis2.available() > 0) {
            count = fis2.read(buffer);
            fot1.write(buffer, 0, count);
        }

        byte[] buffer2 = new byte[fis3.available()];
        int count1 = 0;

        while (fis3.available() > 0) {
            count1 = fis3.read(buffer2);
            fot1.write(buffer2, 0, count1);
        }

        fis2.close();
        fis3.close();
        fot1.close();


    }
}
