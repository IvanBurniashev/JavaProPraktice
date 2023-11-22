package org.example._2023_11_20.task3;

public class Main {
    // Есть класс, унаследованный от Thread.
    // На базе этого класса нужно создать пять объектов (пять потоков).
    // У каждого потока должен быть целочисленный идентификатор.
    // При создании объектов им автоматически должны назначаться идентификаторы
    // в порядке возрастания. То есть у первого объекта id - 1, у второго id - 2 и т.д.
    // Задача каждого потока - увеличить пять раз значение общей переменной на
    // значение своего идентификатора.
    // То есть первый поток должен увеличить значение переменной пять раз на 1,
    // второй - пять раз на 2 и т.д.
    // Вывести в консоль переменную. Ожидаемое значение - 75.
    public static void main(String[] args) throws InterruptedException {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        MyClass myClass3 = new MyClass();
        MyClass myClass4 = new MyClass();
        MyClass myClass5 = new MyClass();

        myClass1.start();
        myClass2.start();
        myClass3.start();
        myClass4.start();
        myClass5.start();

//        myClass1.join();
//        myClass2.join();
//        myClass3.join();
//        myClass4.join();
//        myClass5.join();

        System.out.println(MyClass.common);
    }
}
