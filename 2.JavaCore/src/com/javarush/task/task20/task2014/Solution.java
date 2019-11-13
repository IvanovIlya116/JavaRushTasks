package com.javarush.task.task20.task2014;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.util.InputMismatchException;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream outputStream = new FileOutputStream("c:/data2.txt");
        ObjectOutputStream output = new ObjectOutputStream(outputStream);
        Solution savedObject = new Solution(1);
        Solution anotherObject = new Solution(5);
        output.writeObject(savedObject);
        output.writeObject(anotherObject);
        outputStream.close();
        output.close();


        FileInputStream inputStream = new FileInputStream("c:/data.txt");
        ObjectInputStream input = new ObjectInputStream(inputStream);
        Object object = input.readObject();
        inputStream.close();
        input.close();
        System.out.println(object);
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;





    public Solution(int temperature) throws IOException {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
