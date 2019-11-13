package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, String> map = new TreeMap<>();
        String fileName;
        String fileNameEnd = null;
        while (true) {
            String s = reader.readLine();

            if (s.equals("end")) break;
            fileName = s;
            fileNameEnd = s.substring(0, s.indexOf(".part"));
            int part = Integer.parseInt(s.substring(s.indexOf("part") + 4));

            map.put(part, fileName);
        }

        for (Map.Entry e : map.entrySet()) {
            String file = (String) e.getValue();
            FileInputStream fis = new FileInputStream(new File(file));
            FileOutputStream fos = new FileOutputStream(new File(fileNameEnd), true);
            int count = 0;
            byte[] buffer = new byte[fis.available()];
            while (fis.available() > 0) {
                count = fis.read(buffer);
                fos.write(buffer);

                fis.close();
                fos.close();
            }
        }


    }
}
