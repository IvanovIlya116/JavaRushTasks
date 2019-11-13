package com.javarush.task.task24.task2401;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
    public void identify() {
        System.out.println("I realize interface");
    }

    public void danceNow() {
        System.out.println("Everybody, dance now!!!");
    }
}
