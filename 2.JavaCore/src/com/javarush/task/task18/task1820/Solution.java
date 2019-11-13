package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;


/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName1);
        FileOutputStream fos = new FileOutputStream(fileName2);
        char[] array = new char[fis.available()];

        while (fis.available() > 0) {
            for (int i = 0; i < array.length; i++) {
                array[i] = (char)fis.read();
            }
            String s = String.copyValueOf(array);



            for (String string : s.split(" ") ) {
                int a = (int) Math.round(Double.parseDouble(string));
                string = Integer.toString(a);
                string += " ";
                fos.write(string.getBytes());
            }


        }
        fis.close();
        fos.close();



    }
}
