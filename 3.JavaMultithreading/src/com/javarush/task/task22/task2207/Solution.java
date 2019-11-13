package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<>();
        String text = "";

        while (fileReader.ready()) {
            text += fileReader.readLine() + " ";
        }

        String[] array = text.split(" ");
        for (int i = 0; i < array.length; i++) {
           list.add(array[i]);
        }

        for (int i = 0; i < list.size() - 1; i++) {
            String first = list.get(i);

            for (int j = i + 1; j < list.size(); j++) {
                String second = list.get(j);
                StringBuilder builder = new StringBuilder(second);
                if (first.equals(builder.reverse().toString())) {
                    Pair pair = new Pair();
                    pair.first = first;
                    pair.second = second;
                    if (!result.contains(pair)) result.add(pair);
                }

            }
        }
        for (Pair pair: result) System.out.println(pair);
        reader.close();
        fileReader.close();

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
