package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/*
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        Number result;

        try {
            BigInteger bInt = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());

            if (bInt.compareTo(new BigInteger("0", 10)) < 0) {
                throw new NumberFormatException("Invalid result number (less then 0).");
            }

            result = new Number(expectedNumberSystem, bInt.toString(expectedNumberSystem.getNumberSystemIntValue()));

        } catch (Throwable e) {
            throw new NumberFormatException(e.getMessage());
        }

        return result;
    }
}