package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.*;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName1);
        FileOutputStream fot =  new FileOutputStream(fileName2);

        byte[] buffer = new byte[fis.available()];
        int count = 0;
        while (fis.available() > 0) {
            count = fis.read(buffer);

        }
        for (int i = 0; i < buffer.length / 2; i++) {
            int temp = buffer[i];
            buffer[i] = buffer[buffer.length - 1 - i];
            buffer[(int) buffer.length - 1 - i] = (byte) temp;
        }

        fot.write(buffer, 0, count);


        fis.close();
        fot.close();

    }
}
