package com.stats.app;

import com.stats.app.utility.Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class StudentStats {
    private ArrayList<HashMap<String, Object>> studentDetailsList;
    private ArrayList<Integer> subjectsTotalList;

    static {
        System.out.println("Student Summary");
        System.out.println("---------------***---------------");
    }

    //  Constructor
    public StudentStats() {
        this.studentDetailsList = Common.getList();
        this.subjectsTotalList = Common.getTotalSubject();
        displayRespectiveStudentStats();
    }

    /*
    *   Display the Each student details
    * */
    public void displayRespectiveStudentStats() {
        final int[] index = {0};
        studentDetailsList.forEach(x -> {
            int failedSubjectsNumber = Common.noOfSubjetsFailed(x.get("marks")); // Get the subject failed number
            HashMap<String, Integer> map = (HashMap<String, Integer>) x.get("marks");  // converting the object into hashmap
            ArrayList<String> marksDetails = new ArrayList<>(); // ArrayList to store the subject along with marks
            Set<String> keys = map.keySet();    // Get the keys of map

            for (String key : keys) {
                marksDetails.add(key + ": " + map.get(key));    // Adding the each element into the ArrayList
            }
            // Displaying the Student summary
            System.out.println(x.get("name") + ":");
            System.out.println("----------");
            System.out.println("Marks: " + marksDetails);
            System.out.println("Total Subjects: " + subjectsTotalList.get(index[0]));
            System.out.println("Subjects Failed: " + failedSubjectsNumber);
            Common.calculateMinMaxAvg();    // Calculate the min,max & avg value
            index[0]++; // incrementing the index
            System.out.println();
        });
        SubjectStats subjectStats = new SubjectStats();
    }


}
