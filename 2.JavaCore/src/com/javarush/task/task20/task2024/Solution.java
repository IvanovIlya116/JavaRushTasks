package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution1 = new Solution();
        solution1.node = 1;
        Solution solution2 = new Solution();
        solution2.node = 2;
        Solution solution3 = new Solution();
        solution3.node = 3;
        solution1.edges.add(solution2);
        solution1.edges.add(solution3);
        solution1.edges.add(solution2);
        solution1.edges.add(solution1);

        String fileName = "c:/data.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        oos.writeObject(solution1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        Solution loadedS = (Solution)ois.readObject();
        ois.close();

        System.out.println("original:");
        System.out.println(solution1.node);
        for (Solution s : solution1.edges) System.out.print(s.node + " ");

        System.out.println("\nloaded:");
        System.out.println(loadedS.node);
        for (Solution s : loadedS.edges) System.out.print(s.node + " ");
    }
}