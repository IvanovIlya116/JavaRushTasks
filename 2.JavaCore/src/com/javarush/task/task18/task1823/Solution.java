package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread  t= new ReadFile();
        t.run();
    }

    public static class ReadThread extends Thread {


        public ReadThread(String fileName) throws IOException {
            //implement constructor body
            //           System.out.println(" File Name is: "+ fileName);
            HashMap<Integer, Integer> Tempmap = new HashMap<>();
            FileInputStream file = new FileInputStream(fileName);
            while (file.available() > 0) {
                int data = file.read();
                Integer count = Tempmap.get(data);
                Tempmap.put(data, count == null ? 1 : count + 1);
            }
            file.close();
            for (Map.Entry<Integer, Integer> item : Tempmap.entrySet()) {
                if (item.getValue() == Collections.max(Tempmap.values())) {//выводим Максимальное значение мапы
                    resultMap.put(fileName, item.getKey());
                }
            }
        }

        // implement file reading here - реализуйте чтение из файла тут
    }

    public static class ReadFile extends Thread {

        public void run(){
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

            String Str= null;
            try {
                Str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            while(!Str.equals("exit")) {

                try {
                    Str=reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ReadThread rd = null;
                try {
                    rd = new ReadThread(Str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                rd.start();

            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            }

        }





