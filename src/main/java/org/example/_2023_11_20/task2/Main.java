package org.example._2023_11_20.task2;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    // Есть общая целочисленная переменная (счётчик).
    // Есть три потока - главный и два побочных. Побочный, дочерний - тот который мы создаем.
    // Каждый поток должен инкрементировать общую переменную 1 миллион раз.
    // После этого вывести в консоль значение переменной (ожидаемое значение - 3 000 000).
public static AtomicInteger counter = new AtomicInteger();//потокобезопасный Integer

    public static void main(String[] args) {

        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

        Thread thread = new Thread(new MyThread2());
        thread.start();

        for (int i = 0; i < 1000000; i++) {
            counter.incrementAndGet();
        }

        try {
            myThread1.join();//ждать будет тот поток, в котором запустился этот поток, т.е. в данном случае это поток main
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter);
    }

}
