package com.stats.app;

import java.util.HashMap;

public class StudentDetails {
    private int id;
    private String name;
    private HashMap<String, Integer> marks;

    StudentDetails(int id, String name, HashMap<String, Integer> marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    /*

        public HashMap<String, Integer> getMarks() {
            return marks;
        }

        public int getId() {
            return id;
        }

        public String getName() {
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
    */
    public void displayStudentDetails() {
        System.out.println(" Name: " + this.name + " Marks: " + this.marks);
    }
}
