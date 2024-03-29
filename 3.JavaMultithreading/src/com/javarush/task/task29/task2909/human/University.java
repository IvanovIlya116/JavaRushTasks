package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private  int age;

    public University(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student: students) {
            if (student.getAverageGrade() == averageGrade) return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        List<Double> grades = new ArrayList<>();
        for (Student student : students) {
            grades.add(student.getAverageGrade());
        }
        double max = Collections.max(grades);
       for (Student student : students) {
           if (max == student.getAverageGrade()) return student;
       }
        return null;
    }

    public Student getStudentWithMinAverageGrade() {
        List<Double> grades = new ArrayList<>();
        for (Student student : students) {
            grades.add(student.getAverageGrade());
        }
        double min = Collections.min(grades);
        for (Student student : students) {
            if (min == student.getAverageGrade()) return student;
        }
        return null;
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}