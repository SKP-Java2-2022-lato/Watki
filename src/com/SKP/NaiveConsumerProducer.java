package com.SKP;

import java.time.Duration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class NaiveConsumerProducer {
    private static final Random genertor = new Random();
    private static final Queue<String> queue = new LinkedList<>();


    public static void run(){
        int itemCount = 5;

        // producent
        Thread producer = new Thread(() -> {
            for(int i=0; i<itemCount; i++){
                try {
                    Thread.sleep(Duration.ofSeconds(genertor.nextInt(5)).toMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (queue){
                    queue.add("Produkt numer "+ i);
                }
                System.out.println("Wyprodukowano produkt numer "+ i);
            }
        });

        // konsument
        Thread consumer = new Thread(()->{
            int itemsLeft = itemCount;
            while(itemsLeft > 0){
                String item;
                synchronized (queue){
                    if(queue.isEmpty()){
                        continue;
                    }
                    item = queue.poll();
                    itemsLeft--;
                    System.out.println("Konsument otrzymal produkt numer "+ item);
                }
            }
        });

        consumer.start();
        producer.start();
    }
}
