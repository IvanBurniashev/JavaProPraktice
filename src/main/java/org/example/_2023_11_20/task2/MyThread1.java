package org.example._2023_11_20.task2;

public class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            Main.counter.incrementAndGet();
        }
    }
}
