package com.javarush.task.task18.task1808;

import javax.swing.plaf.ViewportUI;
import java.beans.FeatureDescriptor;
import java.io.*;
/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream fis1 = new FileInputStream(fileName1);
        FileOutputStream fot2 = new FileOutputStream(fileName2);
        FileOutputStream fot3 = new FileOutputStream(fileName3);

           int count = 0;

        byte[] buffer = new byte[fis1.available()];
          while (fis1.available() > 0) {


            count = fis1.read(buffer);
        }
          if (count % 2 == 0) {
              fot2.write(buffer, 0, count / 2);
              fot3.write(buffer, count / 2, count / 2);
          } else {
              fot2.write(buffer, 0, count / 2 + 1);
              fot3.write(buffer, count / 2 + 1, count / 2);
          }
          fis1.close();
          fot2.close();
          fot3.close();
    }
}
