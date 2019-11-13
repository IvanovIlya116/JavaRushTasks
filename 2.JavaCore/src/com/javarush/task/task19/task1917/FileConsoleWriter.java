package com.javarush.task.task19.task1917;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.*;

public class FileConsoleWriter {

    private FileWriter fileWriter;

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) throws IOException {
        fileWriter = new FileWriter(fd);
    }

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);

        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        ow.write(cbuf, off, len);
        ow.close();
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
       // OutputStreamWriter ow = new OutputStreamWriter(System.out);
        //ow.write(c);
        //ow.close();
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        ow.write(str);
        ow.close();
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        ow.write(str, off, len);
        ow.close();
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        ow.write(cbuf);
        ow.close();
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) {

    }

}
