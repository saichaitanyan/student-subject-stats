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


    private String getName() {
        return name;
    }

    /* Display the student details along with marks respectively*/
    static public void displayStudentDetails() {
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        ArrayList<Integer> subjectsTotalList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            HashMap<String, Integer> m = GenerateMarks.generateStudentMarks();

            StudentDetails s = new StudentDetails(i, "Student" + (i + 1), m);

            HashMap<String, Object> hashMap = new HashMap<>();

            Set<String> keys = s.getMarks().keySet();
            System.out.println("Name:  " + s.getName());
            System.out.print("Marks : ");

            HashMap<String, Object> mappingData = new HashMap<>();

            for (String key : keys) {
                System.out.print(key + " " + s.marks.get(key) + " ");
                mappingData.put(key, s.marks.get(key));
            }

            System.out.println();
            hashMap.put("id", i);
            hashMap.put("name", "Student" + (i + 1));
            hashMap.put("marks", mappingData);

            list.add(hashMap);  // To store the complete students details
            subjectsTotalList.add(mappingData.size());  // To store the total subjects attended by students
        }
        System.out.println();   // Create  a new line for spacing

        Common.setList(list);         // Passing the arraylist with HashMap generics for furthuer purpose
        Common.setTotalSubject(subjectsTotalList);    // Passing the arraylist with HashMap generics for furthuer purpose
    }
}



