package com.javarush.task.task18.task1828;

/*
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        reader = new BufferedReader(new FileReader(fileName));



        if(args.length > 0) {

            ArrayList<String> priceList = new ArrayList<>();

            while (reader.ready()){
                priceList.add(reader.readLine());
            }

            if(args[0].equals("-u")){
                String id = args[1];
                String productName = args[2];
                String price = args[3];
                String quantity = args[4];

                while (id.length() < 8) {
                    id += " ";
                }

                while (productName.length() < 30) {
                    productName += " ";
                }

                while (price.length() < 8) {
                    price += " ";
                }

                while (quantity.length() < 4) {
                    quantity += " ";
                }

                String textForWrite = id + productName + price + quantity;

                for (String a : priceList){
                    if(a.startsWith(id))
                        priceList.set(priceList.indexOf(a), textForWrite);
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));


                writer.write(priceList.get(0));

                writer = new BufferedWriter(new FileWriter(fileName, true));

                for(int i = 1; i < priceList.size(); i++){
                    writer.newLine();
                    writer.write(priceList.get(i));
                }
                writer.close();
            }

            if(args[0].equals("-d")){
                String id = args[1];

                while (id.length() < 8) {
                    id += " ";
                }

                for (String a : priceList){
                    if(a.startsWith(id))
                        priceList.remove(priceList.indexOf(a));
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

                writer.write(priceList.get(0));

                writer = new BufferedWriter(new FileWriter(fileName, true));

                for(int i = 1; i < priceList.size(); i++){
                    writer.newLine();
                    writer.write(priceList.get(i));
                }
                writer.close();

            }

        }

        reader.close();

    }
}
