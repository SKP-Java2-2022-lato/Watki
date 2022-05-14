package com.SKP;

public class NestedThread extends Thread {

    private final int children;

    NestedThread(int children){
        this.children = children;
    }

    @Override
    public void run() {

       if(children > 0){
           NestedThread childrenThread = new NestedThread(children - 1);
           childrenThread.start();
           try {
               childrenThread.join();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
        System.out.println(getName());
    }
}
