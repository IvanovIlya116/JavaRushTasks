package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    private static long serialVersionUID = 1L;

    public static class SubSolution extends Solution {
        private static long serialVersionUID = 11L;

        private void writeObject(ObjectOutputStream outputStream) throws NotSerializableException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream inputStream) throws NotSerializableException {
            throw  new NotSerializableException();
        }


    }

    public static void main(String[] args) {


    }
}
