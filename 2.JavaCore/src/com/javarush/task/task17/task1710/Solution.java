package com.javarush.task.task17.task1710;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;


/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static String s;

    static {
        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
       String args1[] = s.split(" ");
        try {
            switch (args1[0]) {
                case "-c": {
                    if (args1[2].equals("м")) {
                        allPeople.add(Person.createMale(args1[1], dateFormat.parse(args1[3])));
                    } else {
                        allPeople.add(Person.createFemale(args1[1], dateFormat.parse(args1[3])));
                    }
                    System.out.println(allPeople.size() - 1);
                }

                case "-u": {
                    Person person = allPeople.get(Integer.parseInt(args1[1]));
                    if (args1[3].equals("м")) {
                        person.setName(args1[2]);
                        person.setSex(Sex.MALE);
                        person.setBirthDate(dateFormat.parse(args1[4]));
                    } else {
                        person.setName(args1[2]);
                        person.setSex(Sex.FEMALE);
                        person.setBirthDate(dateFormat.parse(args1[4]));
                    }
                    break;
                }

                case "-d": {
                    Person person = allPeople.get(Integer.parseInt(args1[1]));
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDate(null);
                    break;
                }

                case "-i": {
                    Person person = allPeople.get(Integer.parseInt(args1[1]));
                    if (person.getSex() == Sex.MALE) {
                        System.out.println(person.getName() + " м " + dateFormat1.format(person.getBirthDate()));
                    } else {
                        System.out.println(person.getName() + " ж " + dateFormat1.format(person.getBirthDate()));

                    }
                    break;
                }
            }
        } catch (Exception e) {

        }
    }
}
