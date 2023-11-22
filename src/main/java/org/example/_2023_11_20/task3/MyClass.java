package org.example._2023_11_20.task3;

import java.util.concurrent.atomic.AtomicInteger;

public class MyClass extends Thread {
    private int id;
    public static int currentId = 0;
    public static AtomicInteger common = new AtomicInteger();

    public MyClass() {
        this.id = ++currentId;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            common.getAndAdd(id);
        }
    }
}
