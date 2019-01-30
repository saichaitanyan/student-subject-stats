package com.stats.app;

import com.stats.app.utility.Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class StudentDetails {
    private int id;
    private String name;
    static private HashMap<String, Integer> marks;

    private StudentDetails(int id, String name, HashMap<String, Integer> marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    private HashMap<String, Integer> getMarks() {
        return this.marks;
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
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            HashMap<String, Integer> m = GenerateMarks.generateStudentMarks();
            StudentDetails s = new StudentDetails(i, "Student" + (i + 1), m);
            HashMap<String, Object> hashMap = new HashMap<>();

            Set<String> keys = s.getMarks().keySet();
            System.out.println("Name:  " + s.getName());
            System.out.print("Marks : ");

            for (String key : keys) {
                System.out.print(key + " " + s.marks.get(key) + " ");
            }
            System.out.println();
            hashMap.put("id", i);
            hashMap.put("name", "Student" + (i + 1));
            hashMap.put("marks", m);
            list.add(hashMap);
            System.out.println(list);
        }
        System.out.println();
        // Passing the arraylist with HashMap generics for furthuer purpose
//        System.out.println(":::::::::::" + list);
        Common.setList(list);
    }
}



