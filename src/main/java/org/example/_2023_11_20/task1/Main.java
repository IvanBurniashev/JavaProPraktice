package org.example._2023_11_20.task1;

public class Main {

    // Есть три цикла.
    // Первый цикл выводит в консоль числа от 0 до 9 с паузой в 300 мс.
    // Второй - числа от 100 до 109 с паузой в 200 мс.
    // Третий - числа от 10000 до 10009 с паузой в 500 мс.
    // Все три цикла должны работать одновременно (один из них в main-потоке).
    // Два остальных потока должны быть созданы разными способами.

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

        Thread thread = new Thread(new MyThread2());
        thread.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }
}