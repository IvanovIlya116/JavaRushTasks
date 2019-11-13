package com.javarush.task.task19.task1914;

import java.io.*;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = new PrintStream(System.out);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        String result = outputStream.toString();



       String[] output =  result.split(" ");

       int numberOne = Integer.parseInt(output[0]);
       int numberTwo = Integer.parseInt(output[2]);
       int sum = numberOne + numberTwo;
       int residual = numberOne - numberTwo;
       int multiplication = numberOne * numberTwo;
        System.setOut(consoleStream);
       if (output[1].equals("+")) System.out.println(numberOne + " + " + numberTwo + " = " + sum);
       else if (output[1].equals("-")) System.out.println(numberOne + " - " + numberTwo + " = " + residual);
       else if (output[1].equals("*")) System.out.println(numberOne + " * " + numberTwo + " = " + multiplication);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

