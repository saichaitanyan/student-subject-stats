package com.stats.app.utility;

import java.util.*;

public class Common {

    private static Object object = null;
    private static ArrayList<Integer> totalSubject = new ArrayList<>();

    public Common(ArrayList<HashMap<String, Object>> list) {
        System.out.println(list);

    }

    private static ArrayList<HashMap<String, Object>> list = new ArrayList<>();
    private static Set<String> keys = new HashSet<>();

    /* Caculate the minimum,maximum & average marks*/
    public static void calculateMinMaxAvg() {
        ArrayList<Integer> list = convertObjToArrayList(object);
        int minIndex = minValueIndex(list);
        int maxIndex = maxValueIndex(list);
        int maxValue = list.get(maxIndex);
        int minValue = list.get(minIndex);
        System.out.println("Max: " + maxValue + ",  Min: " + minValue + ",  Avg: " + avgValue(list));
    }

    public static ArrayList<HashMap<String, Object>> getList() {
        return list;
    }

    public static void setList(ArrayList<HashMap<String, Object>> arrayList) {
        list = arrayList;
    }

    public static void setTotalSubject(ArrayList<Integer> list) {
        totalSubject = list;
    }

    public static ArrayList<Integer> getTotalSubject() {
        return totalSubject;
    }

    /* Method that return number of subject failed*/
    public static int noOfSubjetsFailed(Object obj) {
        object = obj;
        ArrayList<Integer> totalMarks = convertObjToArrayList(obj);
        ArrayList<Integer> dummmyMarksList = new ArrayList<>(totalMarks);
        ArrayList<Integer> totalSubjectsFailed = new ArrayList<>();
//        ArrayList<Integer> totalMarks = convertObjToArrayList(obj);
//        ArrayList<Integer> dummmyMarksList = new ArrayList<>(totalMarks);
//        ArrayList<Integer> totalSubjectsFailed = new ArrayList<>();

        ArrayList<Integer> finalTotalMarks = totalMarks;
        dummmyMarksList.forEach(mark -> {

            int indexOfMinValue = minValueIndex(finalTotalMarks);

            if (finalTotalMarks.get(indexOfMinValue) < 25) {
                totalSubjectsFailed.add(finalTotalMarks.get(indexOfMinValue));
                finalTotalMarks.remove(indexOfMinValue);
            }
        });
//        totalMarks = dummmyMarksList;
        return totalSubjectsFailed.size();
    }

    /* Return the index of minimum value in the ArrayList*/
    public static int minValueIndex(ArrayList<Integer> col) {
        return col.indexOf(Collections.min(col));
    }

    /* Return the index of maximum value in the ArrayList*/
    public static int maxValueIndex(ArrayList<Integer> col) {
//        System.out.println("max index value " + col.indexOf(Collections.max(col)));
        return col.indexOf(Collections.max(col));
    }

    /* Return the index of maximum value in the ArrayList*/
    public static double avgValue(ArrayList<Integer> col) {

        int sum = 0;
        for (int i = 0; i < col.size(); i++) {
            sum += col.get(i);
        }
//        double averageValue = ;
        return (double) (sum / col.size());
    }

    /* Convert an HashMap reference-Object into ArrayList*/
    public static ArrayList<Integer> convertObjToArrayList(Object obj) {
        HashMap<String, Integer> map = (HashMap<String, Integer>) obj;
        Collection<Integer> values = map.values();
        ArrayList<Integer> list = new ArrayList<>(values);
        return list;
    }
}
