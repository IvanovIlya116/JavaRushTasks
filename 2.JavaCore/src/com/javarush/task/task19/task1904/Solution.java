package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {


    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {



                String string = fileScanner.nextLine();
                String[] fromFile = string.split(" ");
                String firstNameFromFile = fromFile[1];
                String lastNameFromFile = fromFile[0];
                String middleNameFromFile = fromFile[2];
                String dateFromFile = fromFile[3] + " " +  fromFile[4] + " " + fromFile[5];
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);

                Date newDate = new Date();

            try {
               newDate = dateFormat.parse(dateFromFile);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Person person = new Person(firstNameFromFile, middleNameFromFile, lastNameFromFile, newDate);


            return person;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();

        }
    }
}
