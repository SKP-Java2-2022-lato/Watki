package com.SKP;

public class Counter {
    private int value;

    public void increment(){
        synchronized (this){
            value += 1;
        }

    }

    // to samo co wyzej
    public  synchronized void incrementSync(){
        value += 1;
    }

    public int getValue() {
        return value;
    }
}
