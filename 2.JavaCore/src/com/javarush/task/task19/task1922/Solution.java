package com.javarush.task.task19.task1922;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.io.*;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));

        String line;
        List<String> resultList = new LinkedList<String>();
        while ((line = fReader.readLine()) != null) {

            String[] splitStr = line.split(" ");
            int count = 0;
            for (String s : splitStr) {
                if (words.contains(s)) {
                    count++;
                } else System.out.println("Не содержит");
            }
            if (count == 2) {
                System.out.println(line);
                //resultList.add(line);
            }
        }
        console.close();
        fReader.close();

        for (String s : resultList) {
            //System.out.println(s);
        }
    }
}