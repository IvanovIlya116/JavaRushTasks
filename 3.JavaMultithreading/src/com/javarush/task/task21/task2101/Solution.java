package com.javarush.task.task21.task2101;

import java.nio.ByteBuffer;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        int ipInt = ByteBuffer.wrap(ip).getInt();
        int maskInt = ByteBuffer.wrap(mask).getInt();
        int res = ipInt & maskInt;
        byte[] netAddress = ByteBuffer.allocate(4).putInt(res).array();
        return netAddress;
    }

    public static void print(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0')).append(" ");
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        System.out.println(sb.toString());
    }
}