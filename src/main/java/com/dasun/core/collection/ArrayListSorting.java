package com.dasun.core.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListSorting {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(12,"Saman"));
        studentList.add(new Student(1,"Kamal"));
        Collections.sort(studentList);
        for(Student student:studentList){
            System.out.println(student.getId());
        }
    }
}

class Student implements Comparable<Student> {

    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student student) {
        if (student.id < id) {
            return 1;
        } else if (student.id == id) {
            return 0;
        } else {
            return -1;
        }
    }
}

