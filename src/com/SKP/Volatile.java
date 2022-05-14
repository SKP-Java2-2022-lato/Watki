package com.SKP;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Volatile {
    private static volatile boolean isDone = false;

    public static void run(){
        Thread backgroundJob = new Thread(() ->{
            try {
                Thread.sleep(Duration.ofSeconds(2).toMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Skonczylem!");
            isDone = true;
        });

        Thread heavyWorker = new Thread(() ->{
            LocalDateTime start = LocalDateTime.now();
            while (!isDone){
                // cos tam rob
            }
            long durationInMills = ChronoUnit.MILLIS.between(start, LocalDateTime.now());
            System.out.println(durationInMills);
        });

        heavyWorker.start();
        backgroundJob.start();
    }
}
