package com.javarush.task.task18.task1814;


import java.io.*;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {


    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        char[] array = fileName.toCharArray();
        try {

            if (!(array[array.length - 1] == 't' && array[array.length - 2] == 'x' && array[array.length - 3] == 't' && array[array.length - 4] == '.')) {

                throw new UnsupportedFileNameException();
            }
        }
        catch (UnsupportedFileNameException e) {
            super.close();
            throw new UnsupportedFileNameException();
        }






    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        TxtInputStream txt = new TxtInputStream(fileName);
    }
}

