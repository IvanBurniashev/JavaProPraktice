package org.example._2023_11_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private int studentID = 1;
    private Map<Integer, Student> studentsMap = new HashMap<>();

    public void addStudent(String name, int age, Degree degree) {
        Student student = new Student(studentID++, name, age, degree);
        studentsMap.put(student.getId(), student);
    }

    public List<Student> getAListOfAllStudents() {
        List<Student> studentList = new ArrayList<>(studentsMap.values());
        return studentList;
    }

    public int getCountStudent() {
        return studentsMap.size();
    }

    public int getDegreeStudentCount(Degree degree) {
        return (int) studentsMap.values().stream()
                .filter(student -> student.getDegree() == degree)
                .count();
    }

    public double getAvgAgeStudent(){
        return 0;
    }
}