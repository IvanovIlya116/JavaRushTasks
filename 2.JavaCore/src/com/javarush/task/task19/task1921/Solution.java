package com.javarush.task.task19.task1921;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.*;
import java.util.Locale;


/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        String personName;
        Date personDate;
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
        ArrayList<String> listOfPersons = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            listOfPersons.add(line);
        }

        for (int i = 0; i < listOfPersons.size(); i++) {
            personName = listOfPersons.get(i).replaceAll("\\d", "").trim();
            personDate = format.parse(listOfPersons.get(i).replace(personName, ""));
            PEOPLE.add(new Person(personName, personDate));
        }
        reader.close();


    }
}
