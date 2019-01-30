package com.stats.app;

import java.util.HashMap;
import java.util.Set;

public class StudentDetails {
    private int id;
    private String name;
    private HashMap<String, Integer> marks;

    private StudentDetails(int id, String name, HashMap<String, Integer> marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }


    private HashMap<String, Integer> getMarks() {
        return marks;
    }

    public int getId() {
        return id;
    }

    private String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarks(HashMap<String, Integer> marks) {
        this.marks = marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    public void displayStudentDetails() {
    //        System.out.println(" Name: " + this.name + " Marks: " + this.marks);
    //    }

    static public void displayStudentDetails() {
        for (int i = 0; i < 5; i++) {
            StudentDetails s = new StudentDetails(i, "Student" + (i + 1), GenerateMarks.generateStudentMarks());
            Set<String> keys = s.getMarks().keySet();
            System.out.println("Name:  " + s.getName());
            System.out.print("Marks : ");
            for (String key : keys
            ) {
//                System.out.print("");
                System.out.print(key + " " + s.marks.get(key) + ", ");
            }
            System.out.println();
        }
    }
}



