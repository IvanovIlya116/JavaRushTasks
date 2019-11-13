package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            String tag = args[0];
            //String tag = "span";

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String fileName = console.readLine();
            console.close();
            BufferedReader fReader = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = fReader.readLine()) != null) {
                sb.append(line);
            }
            fReader.close();
            line = sb.toString();


            String startTag = "<" + tag;
            String endTag = "</" + tag + ">";
            int startIdx = -1;
            int endIdx;
            while (true) {
                startIdx = line.indexOf(startTag, startIdx + 1);
                if (startIdx == -1) {
                    break;
                }
                endIdx = line.indexOf(endTag, startIdx + tag.length() + 2);

                int tmpIdx = startIdx + tag.length() + 1;
                String tmp = line.substring(0, endIdx);
                while (true) {
                    tmpIdx = tmp.indexOf(startTag, tmpIdx + 1);
                    if (tmpIdx != -1) {
                        endIdx = line.indexOf(endTag, endIdx + endTag.length());
                        tmp = line.substring(0, endIdx);
                        continue;
                    }
                    break;
                }

                System.out.println(line.substring(startIdx, endIdx + tag.length() + 3));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}