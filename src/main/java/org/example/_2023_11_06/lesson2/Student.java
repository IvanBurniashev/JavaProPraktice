package org.example._2023_11_06.lesson2;

//        1. Создайте класс Студент.
//        2. У студента должны быть характеристики: ID, имя, возраст, учебная степень
//        (в виде Enum Degree - BACHELOR и MASTER).

import java.util.Objects;

public class Student {

    private int id;
    private String name;
    private int age;
    private Degree degree;

    // Конструктор имеет модификатор доступа по умолчанию,
    // чтобы не было возможности создать студента напрямую, не через сервис.

    Student(int id, String name, int age, Degree degree) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.degree = degree;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Degree getDegree() {
        return degree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && Objects.equals(name, student.name) && degree == student.degree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, degree);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", degree=" + degree +
                '}';
    }
}