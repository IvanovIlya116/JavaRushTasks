package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.*;
import java.io.*;

import static java.util.Collections.frequency;

/*
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList  list = new ArrayList ();
        ArrayList  list2 = new ArrayList ();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream inputStream =new FileInputStream(file);
        while (inputStream.available()>0) {
            list.add(inputStream.read());

        }


        int count = 1;
        for(int i = 0; list.size()> i; i++) {
            if (frequency(list, list.get(i)) < count) {

                count = frequency(list, list.get(i));

            }
        }
        for(int i = 0; list.size() > i; i++){

            if(frequency(list, list.get(i)) == count) {


                if(!list2.contains(list.get(i))) {
                    System.out.print(list.get(i) + " ");
                    list2.add(list.get(i));

                }
            }


        }
        inputStream.close();
    }
}

