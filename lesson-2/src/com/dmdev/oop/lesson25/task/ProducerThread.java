package com.dmdev.oop.lesson25.task;

import java.util.Queue;

public class ProducerThread implements Runnable {
    private final Queue<Integer> list;

    public ProducerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (list.size() < 10) {
                    int random = RandomUtil.getRandom();
                    list.add(random);
//                    list.notifyAll();
                    System.out.println("Producer adds value: " + random);
                } else {
                    System.out.println("Producer does nothing");
                }
                try {
                    int randomWaitValue = 20;
                    System.out.println("Producer waits : " + randomWaitValue);
                    list.wait(randomWaitValue);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
