package com.twg.ttools.concurrent;

public class Synchronize {
    public static void main(String[] args) {
        synchronized (Synchronize.class){
            System.out.println("Synchronize");
        }
    }
}
