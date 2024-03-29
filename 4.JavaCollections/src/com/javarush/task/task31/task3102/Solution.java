package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootDirectory = new File(root);
        List<String> result = new ArrayList<>();
        Queue<File> filesQueue = new PriorityQueue<>();

        Collections.addAll(filesQueue, rootDirectory.listFiles());
        while ( !filesQueue.isEmpty()) {
            File currentFile = filesQueue.remove();

            if (currentFile.isDirectory()) {
                Collections.addAll(filesQueue, currentFile.listFiles());

            } else {
                result.add(currentFile.getAbsolutePath());
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getFileTree("C:\\Users\\misti\\Documents\\files\\folder").toString());
    }
}
