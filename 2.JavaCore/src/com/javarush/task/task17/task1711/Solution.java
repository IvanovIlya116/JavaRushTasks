package com.javarush.task.task17.task1711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    

    public static void main(String[] args) throws IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        

        try {
            switch (args[0]) {

                case "-c":
                    synchronized (allPeople) {

                    for (int i = 0; ; i++) {

                    if (args[2 + i * 3].equals("м")) {
                        allPeople.add(Person.createMale(args[1 + i * 3], dateFormat.parse(args[3 + i * 3])));
                    } else {
                        allPeople.add(Person.createFemale(args[1 + i * 3], dateFormat.parse(args[3 + i * 3])));
                    }
                    System.out.println(allPeople.size() - 1);
                    if (args[4 + i * 3] == null) break;

                }
                    break;
                }



                case "-u":
                    synchronized (allPeople) {
                    for (int i = 0; ; i++) {
                    Person person = allPeople.get(Integer.parseInt(args[1 + i * 4]));
                    if (args[3 + i * 4].equals("м")) {
                        person.setName(args[2 + i * 4]);
                        person.setSex(Sex.MALE);
                        person.setBirthDate(dateFormat.parse(args[4 + i * 4]));
                    } else {
                        person.setName(args[2 + i * 4]);
                        person.setSex(Sex.FEMALE);
                        person.setBirthDate(dateFormat.parse(args[4 + i * 4]));
                    }
                    if (args[5 + i * 4] == null) break;
                }
                    break;
                }

                case "-d":
                    synchronized (allPeople) {
                    for (int i = 0; ; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[1 + i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                        if (args[2 + i] == null) break;
                    }
                    break;
                }

                case "-i":
                    synchronized (allPeople) {
                    for (int i = 0; ; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[1 + i]));
                        if (person.getSex() == Sex.MALE) {
                            System.out.println(person.getName() + " м " + dateFormat1.format(person.getBirthDate()));
                        } else {
                            System.out.println(person.getName() + " ж " + dateFormat1.format(person.getBirthDate()));

                        }
                        if (args[2 + i] == null) break;
                    }
                    break;
                }
            }
        } catch (Exception e) {

        }

    }
}
