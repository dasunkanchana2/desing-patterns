package com.dasun.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * The Student class
 */
class Student implements Comparable<Student> {

    int id;
    String name;
    double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
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

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public int compareTo(Student student) {
        //compare cgpa
        if (cgpa == student.cgpa) {
            //compare name
            if (name.compareTo(student.name) == 0) {
                //compare id
                if (id == student.id) {
                    return 0;
                } else if (id > student.id) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return name.compareTo(student.name);
            }
        } else if (cgpa > student.cgpa) {
            return -1;
        } else {
            return 1;
        }
    }

}

/**
 * The Priorities class
 */
class Priorities {

    /**
     * Get students
     *
     * @param events :events
     * @return: list of Students
     */
    List<Student> getStudents(List<String> events) {

        int eventSize = events.size();
        System.out.println(eventSize);

        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
        for (String event : events) {
            String[] eventArray = event.split("\\s");
            if ("ENTER".equals(eventArray[0])) {
                priorityQueue.add(new Student(
                        Integer.valueOf(eventArray[3]), eventArray[1],
                        Double.valueOf(eventArray[2])));

            } else if ("SERVED".equals(eventArray[0])) {
                priorityQueue.poll();
            }
        }
        return new ArrayList<>(priorityQueue);
    }
}

/**
 * The PriorityQueue class.
 */
public class PriortyQueue {

    public static void main(String[] args) {
        Priorities priorities = new Priorities();
        List<String> events = new ArrayList<>();
        events.add("ENTER John 3.75 50");
        events.add("ENTER Mark 3.8 24");
        events.add("ENTER Shafaet 3.7 35");
        events.add("SERVED");
        events.add("SERVED");
        events.add("ENTER Samiha 3.85 36");
        events.add("SERVED");
        events.add("ENTER Ashley 3.9 42");
        events.add("ENTER Maria 3.6 46");
        events.add("ENTER Anik 3.95 49");
        events.add("ENTER Dan 3.95 50");
        events.add("SERVED");

        List<Student> studentList = priorities.getStudents(events);
        for (Student students : studentList) {
            System.out.println(students.getName());
        }
    }
}
