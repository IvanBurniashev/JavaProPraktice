package org.example._2023_11_20.task1;

public class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 100; i < 110; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }
}
