package com.javarush.task.task30.task3013;

/* 
Набираем код
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 1_000_000_000;
        System.out.println(number);
        System.out.println(Integer.toString(number, 2));

        int lowerBitsNumber = solution.resetLowerBits(number);
        String result = Integer.toString(lowerBitsNumber, 2);
        System.out.println(result);
        System.out.println(lowerBitsNumber);
    }

    public int resetLowerBits(int number) {
        number |= number >> 1;
        number |= number >> 2;
        number |= number >> 3;
        number |= number >> 4;
        number &= ~number >> 1;
        return number;
    }
}