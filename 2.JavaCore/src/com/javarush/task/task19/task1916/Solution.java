package com.javarush.task.task19.task1916;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String oldFileName = console.readLine();
        String newFileName = console.readLine();
        console.close();

        List<String> oldFileLines = readFileLines(oldFileName);
        List<String> newFileLines = readFileLines(newFileName);

        // algorithm work only if data into the files are correct (according to the task)
        boolean iterateByOldFile = true;

        while (oldFileLines.size() > 0 && newFileLines.size() > 0) {

            // iterate by lines in old file
            if (iterateByOldFile)
            {
                if ( oldFileLines.get(0).equals(newFileLines.get(0)) ) {
                    lines.add(new LineItem(Type.SAME, oldFileLines.get(0)));
                    oldFileLines.remove(0);
                    newFileLines.remove(0);
                } else
                if ( oldFileLines.get(0).equals(newFileLines.get(1)) ) {
                    lines.add(new LineItem(Type.ADDED, newFileLines.get(0)));
                    newFileLines.remove(0);
                    iterateByOldFile = !iterateByOldFile;
                } else {
                    lines.add(new LineItem(Type.REMOVED, oldFileLines.get(0)));
                    oldFileLines.remove(0);
                }
            }
            // iterate by lines in new file
            else
            {
                if ( newFileLines.get(0).equals(oldFileLines.get(0)) ) {
                    lines.add(new LineItem(Type.SAME, newFileLines.get(0)));
                    newFileLines.remove(0);
                    oldFileLines.remove(0);
                } else
                if ( newFileLines.get(0).equals(oldFileLines.get(1)) ) {
                    lines.add(new LineItem(Type.REMOVED, oldFileLines.get(0)));
                    oldFileLines.remove(0);
                    iterateByOldFile = !iterateByOldFile;
                } else {
                    lines.add(new LineItem(Type.ADDED, newFileLines.get(0)));
                    newFileLines.remove(0);
                }
            }
        }

        if (oldFileLines.size() > 0) {
            lines.add(new LineItem(Type.REMOVED, oldFileLines.get(0)));
        } else if (newFileLines.size() > 0) {
            lines.add(new LineItem(Type.ADDED, newFileLines.get(0)));
        }
        // file may contain another records, but we don't take it into account

        for (LineItem i : lines) {
            System.out.println(i.type + " " + i.line);
        }
    }

    static List<String> readFileLines(String fileName) throws IOException {
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));
        List<String> fileLines = new ArrayList<String>();
        String line;
        while ((line = fReader.readLine()) != null) {
            fileLines.add(line);
        }
        fReader.close();
        return fileLines;
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}