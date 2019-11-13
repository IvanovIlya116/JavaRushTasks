package com.javarush.task.task18.task1827;

/*
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        reader = new BufferedReader(new FileReader(fileName));

        if(args.length > 0){

            int maxID = 0;
            String text;

            while (reader.ready()){

                text = reader.readLine();

                int loadID = Integer.parseInt(text.substring(0, 8).trim());

                if(loadID > maxID)
                    maxID = loadID;
            }

            maxID = maxID + 1;

            String id = String.valueOf(maxID);
            String productName = args[1];
            String price = args[2];
            String quantity = args[3];

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

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            writer.newLine();
            writer.write(textForWrite);

            reader.close();
            writer.close();
        }

    }
}
