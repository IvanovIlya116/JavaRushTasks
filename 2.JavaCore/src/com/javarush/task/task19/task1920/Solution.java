package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));
        Map<String, Double> map = new TreeMap<String, Double>();
        String line;
        double value;
        while ((line = fReader.readLine()) != null) {
            String[] rec = line.split(" ");
            value = Double.parseDouble(rec[1]);
            if (map.containsKey(rec[0])) {
                map.put(rec[0], map.get(rec[0]) + value);
            } else {
                map.put(rec[0], value);
            }
        }
        fReader.close();

        double max = Collections.max(map.values());
        for (Map.Entry<String, Double> pairs : map.entrySet()) {
            if (max == pairs.getValue()) System.out.println(pairs.getKey());
        }
    }
}