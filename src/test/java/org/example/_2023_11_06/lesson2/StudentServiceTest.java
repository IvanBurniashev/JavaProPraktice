package org.example._2023_11_06.lesson2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    private StudentService service;

    @BeforeEach
    public void init() {
        service = new StudentService();
        service.createStudent("John Walker", 19, Degree.BACHELOR);

    }

    @Test
    public void checkAddNewStudent() {//проверяем добавляется ли наш студент в коллекцию
        Student student = service.getStudentById(1);//проверять будем по id = 1
        assertNotNull(student);
    }

    @Test
    public void checkStudentProperts() {
        Student student = service.getAllStudents().get(0);
        assertEquals("John Walker", student.getName());
        assertEquals(19, student.getAge());
        assertEquals(Degree.BACHELOR, student.getDegree());
    }

    @Test
    public void checkStudentsEqualiti() {
        Student expectedStudent = new Student(1, "John Walker", 19, Degree.BACHELOR);//это ожидаемый обьект
        Student actualStudent = service.getStudentById(1);//достаем обьект по id
        assertEquals(expectedStudent, actualStudent);//метод падает, потому что нужно переопределить метод Equals в Student
        //ссылки разные, поэтому он считает что это разные обьекты.
    }

    @Test
    public void checkStudentsCount() {
        service.createStudent("Garry Trumen", 22, Degree.BACHELOR);
        service.createStudent("Donald Trump", 25, Degree.MASTER);
        int expectedSize = 3;
        int actualSize = service.getStudentsCount();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void checkGetStudentsCountByDegree(){
        service.createStudent("Garry Trumen", 22, Degree.MASTER);
        service.createStudent("Garry Trumen1", 24, Degree.BACHELOR);
        service.createStudent("Garry Trumen2", 27, Degree.MASTER);
        service.createStudent("Garry Trumen3", 26, Degree.BACHELOR);
        long expectedCount = 2;
        long actualCount = service.getStudentsCountByDegree(Degree.MASTER);
        assertEquals(expectedCount,actualCount);
    }

    @Test
    public void checkIncorrectAgeStudent(){
        try {
            service.createStudent("Garry Trumen", 101, Degree.MASTER);
        } catch (IllegalArgumentException e){//если попали сюда, значит все отработало как задумывалось
            return;
        }
        fail();//если попали сюда, значит ошибку не поймали и нужно тест ПРОВАЛИТЬ!
    }
}