package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fos = null;

        while (true) {

            String fileName = null;

                fileName = reader.readLine();


            try {
                fos = new FileInputStream(fileName);
                fos.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);

                break;
            }


        }




    }
}
