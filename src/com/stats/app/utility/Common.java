package com.stats.app.utility;

import java.util.*;

public class Common {

    private static ArrayList<Integer> totalSubject = new ArrayList<>();

    public Common(ArrayList<HashMap<String, Object>> list) {
        System.out.println(list);

    }

    private static ArrayList<HashMap<String, Object>> list = new ArrayList<>();
    private static Set<String> keys = new HashSet<>();

    /* Caculate the minimum,maximum & average marks*/
    public static void calculateMinMaxAvg() {
        list.forEach(x -> {
//            System.out.println(x.get("name") + " " + x.get("marks"));
        });
    }

    public static ArrayList<HashMap<String, Object>> getList() {
        return list;
    }

    public static void setList(ArrayList<HashMap<String, Object>> arrayList) {
        list = arrayList;
        calculateMinMaxAvg();
    }

    public static void setTotalSubject(ArrayList<Integer> list) {
        totalSubject = list;
    }

    public static ArrayList<Integer> getTotalSubject() {
        return totalSubject;
    }

    public static int noOfSubjetsFailed(Object obj) {
        HashMap<String, Integer> map = (HashMap<String, Integer>) obj;
        Collection<Integer> values = map.values();
        ArrayList<Integer> totalMarks = new ArrayList<>(values);
        ArrayList<Integer> dummmyMarksList = new ArrayList<>(totalMarks);
        ArrayList<Integer> totalSubjectsFailed = new ArrayList<>();

        dummmyMarksList.forEach(mark -> {

            int indexOfMinValue = minValueIndex(totalMarks);

            if (totalMarks.get(indexOfMinValue) < 25) {
//                System.out.println(">>>>>> value added");
                totalSubjectsFailed.add(totalMarks.get(indexOfMinValue));
                totalMarks.remove(indexOfMinValue);
            }
        });

        return totalSubjectsFailed.size();
    }

    /*
     *

     * */
    public static int minValueIndex(ArrayList<Integer> col) {
        return col.indexOf(Collections.min(col));
    }
}
