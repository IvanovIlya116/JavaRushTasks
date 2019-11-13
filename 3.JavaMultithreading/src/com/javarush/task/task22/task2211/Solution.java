package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
       BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(args[0]));
       BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(args[1]));

        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");
        byte buffer[] = new byte[8000];

        while (inputStream.available() > 0) {
            inputStream.read(buffer);
            String result = new String(buffer, windows1251);
            outputStream.write(result.getBytes(utf8));
        }
        inputStream.close();
        outputStream.close();
    }
}
