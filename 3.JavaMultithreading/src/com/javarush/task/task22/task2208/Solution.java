package com.javarush.task.task22.task2208;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> db = new HashMap<>();
        db.put("name", "Ivanov");
        db.put("country", "Russia");
        db.put("city", "Kazan");
        System.out.println(getQuery(db));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                builder.append(entry.getKey() + " = \'" + entry.getValue() + "\'" + " and ");
            }
        }
        String result = builder.toString();

        if (result.length() < 1) {
            return "";
        } else return result.substring(0, result.length() -5 );
    }
}
