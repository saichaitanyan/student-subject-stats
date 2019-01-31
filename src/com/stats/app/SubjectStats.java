package com.stats.app;

import com.stats.app.utility.Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class SubjectStats {
    private ArrayList<HashMap<String, Object>> studentDetailsList;
    private HashMap<String, Integer> subjectsMap = new HashMap<>();
    private HashMap<String, ArrayList<Integer>> detailedSubjectMap = new HashMap<>();

    static {
        System.out.println("Subject Summary");
        System.out.println("---------------***---------------");
    }

    public SubjectStats() {
        this.studentDetailsList = Common.getList();
        displayRespectiveSubjectStats();
    }

    /* Display the each subject stats with pass, fail along with max,min & avg marks in that respective subject */
    public void displayRespectiveSubjectStats() {

        detailedSubjectMap = getSubjectDetails();
        Set<String> subjectNameAsKey = Common.convertObjKeysToSet(detailedSubjectMap);
        subjectNameAsKey.forEach(x -> {
            ArrayList<Integer> marksList = detailedSubjectMap.get(x);
//            System.out.println(marksList);
            int failedCount = Common.noOfSubjetsFailed(marksList);
            System.out.println(x + ":");
            System.out.println("Marks: " + detailedSubjectMap.get(x));
            System.out.println("Students Attended: " + detailedSubjectMap.get(x).size());
            System.out.println("Students Failed: " + failedCount);
            Common.calculateMinMaxAvg(marksList);
            System.out.println();
        });
    }

    public Set<String> subjectStatsLogic() {
        ArrayList<Object> objectArrayList = Common.getObjectList();
        for (int i = 0; i < objectArrayList.size(); i++) {

            HashMap<String, Integer> m = (HashMap<String, Integer>) objectArrayList.get(i);
            Set<String> mKeysSet = (Set<String>) Common.convertObjKeysToSet(m);

            if (i + 1 < objectArrayList.size()) {
                HashMap<String, Integer> m1 = (HashMap<String, Integer>) objectArrayList.get(i + 1);
                Set<String> m1KeysSet = (Set<String>) Common.convertObjKeysToSet(m);

                String[] arr = new String[mKeysSet.size()];
                arr = mKeysSet.toArray(arr);

                for (int i1 = 0; i1 < arr.length; i1++) {
                    if (m1KeysSet.contains(arr[i1])) {
                        int getCount = (subjectsMap.get(arr[i1]) != null) ? subjectsMap.get(arr[i1]) : 0;
                        subjectsMap.put(arr[i1], getCount + 1);
                    }
                }
            }
        }
        return Common.convertObjKeysToSet(subjectsMap);
    }

    public HashMap<String, ArrayList<Integer>> getSubjectDetails() {
        Set<String> mapKeySet = (Set<String>) subjectStatsLogic();
        ArrayList<String> arrayList = new ArrayList<>(mapKeySet);
        HashMap<String, ArrayList<Integer>> subjectsDetails = new HashMap<>();
        studentDetailsList.forEach(x -> {
            HashMap<String, Integer> subjectMarks = (HashMap<String, Integer>) x.get("marks");

            for (int i = 0; i < arrayList.size(); i++) {
                String subjectName = arrayList.get(i);
                if (subjectMarks.containsKey(subjectName)) {
                    int _onlyMarks = subjectMarks.get(subjectName);

//                    If subjectDetails map already exist ArrayList
                    if (subjectsDetails.containsKey(subjectName)) {
                        ArrayList<Integer> copy = subjectsDetails.get(subjectName);
                        copy.add(_onlyMarks);
                        subjectsDetails.put(subjectName, copy);
                    } else {
//                    If subjectDetails map does not exist ArrayList
//                    Creating a new ArrayList

                        ArrayList<Integer> subjMarksList = new ArrayList<>();
                        subjMarksList.add(_onlyMarks);
                        subjectsDetails.put(subjectName, subjMarksList);
                    }
                }
            }

        });
        return subjectsDetails;
    }
}
