package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/*
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            list.add(data);
        }
        reader.close();
        inputStream.close();

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
        }

        for (Integer iterator : set) {
            System.out.print(iterator + " ");
        }
    }
}
