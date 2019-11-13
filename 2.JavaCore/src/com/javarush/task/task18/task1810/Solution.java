package com.javarush.task.task18.task1810;

import java.io.*;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            FileInputStream fis = new FileInputStream(reader.readLine());
            byte[] buffer = new byte[fis.available()];
            int count = 0;

            while (fis.available() > 0) {
                count = fis.read(buffer);

            }
            if (count < 1000) {
                fis.close();
                reader.close();
                throw new DownloadException();

            }
        }

    }

    public static class DownloadException extends Exception {

    }
}
