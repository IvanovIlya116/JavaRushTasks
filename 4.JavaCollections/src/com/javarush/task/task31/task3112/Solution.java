package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.nio.file.StandardCopyOption;

import static java.nio.file.Files.move;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        Path temp = Files.createTempFile("tempFile-3112-", ".tmp");

        Files.copy(url.openStream(), temp, StandardCopyOption.REPLACE_EXISTING);

        String fileName = urlString.substring(urlString.lastIndexOf("/") + 1);
        Path downloadFile = downloadDirectory.resolve(fileName);

        Files.move(temp, downloadFile);

        return downloadFile;
    }
}