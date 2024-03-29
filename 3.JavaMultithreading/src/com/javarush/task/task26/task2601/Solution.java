package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {


    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        final double median;

        if (array.length % 2 == 0) {
            median = ((double) array[array.length / 2 - 1] + (double) array[array.length / 2]) / 2;
        } else {
            median = array[array.length / 2];
        }

        Comparator<Integer> comparator = (o1, o2) -> (int) (Math.abs(median - o1) - Math.abs(median - o2));
        Arrays.sort(array, comparator);
        return array;
    }
}
