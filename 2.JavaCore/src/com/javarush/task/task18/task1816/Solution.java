package com.javarush.task.task18.task1816;
import java.io.*;


/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File(args[0]));
        int count = 0;
        while (fis.available() > 0) {
            int readChar = fis.read();
            if ((readChar >= 65 && readChar <= 90) || (readChar >= 97 && readChar <= 122 )) count++;
        }
        System.out.println(count);
        fis.close();
    }
}
