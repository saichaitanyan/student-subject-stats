package com.stats.app.utility;

import java.util.*;

public class Common {

    private static Object object = null;
    private static ArrayList<Integer> totalSubject = new ArrayList<>();
    private static ArrayList<Object> ObjectList = new ArrayList<>();

    public Common(ArrayList<HashMap<String, Object>> list) {
        System.out.println(list);

    }

    private static ArrayList<HashMap<String, Object>> list = new ArrayList<>();
    private static Set<String> keys = new HashSet<>();

    /* Caculate the minimum,maximum & average marks*/
    public static void calculateMinMaxAvg() {
        ArrayList<Integer> list = convertObjValuesToArrayList(object);
        int minIndex = minValueIndex(list);
        int maxIndex = maxValueIndex(list);
        int maxValue = list.get(maxIndex);
        int minValue = list.get(minIndex);
        System.out.println("Max: " + maxValue + ",  Min: " + minValue + ",  Avg: " + avgValue(list));
    }

    public static void calculateMinMaxAvg(ArrayList<Integer> arrayList) {
        ArrayList<Integer> list = arrayList;
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

    public static ArrayList<Object> getObjectList() {
        return ObjectList;
    }

    /* Method that return number of subject failed*/
    public static int noOfSubjetsFailed(Object obj) {
        object = obj;
        ObjectList.add(object);
        ArrayList<Integer> totalMarks = convertObjValuesToArrayList(obj);
        ArrayList<Integer> dummmyMarksList = new ArrayList<>(totalMarks);
        ArrayList<Integer> totalSubjectsFailed = new ArrayList<>();
        ArrayList<Integer> finalTotalMarks = dummmyMarksList;
        totalMarks.forEach(mark -> {

            int indexOfMinValue = minValueIndex(finalTotalMarks);

            if (finalTotalMarks.get(indexOfMinValue) < 25) {
                totalSubjectsFailed.add(finalTotalMarks.get(indexOfMinValue));
                finalTotalMarks.remove(indexOfMinValue);
            }
        });
//        totalMarks = dummmyMarksList;
        return totalSubjectsFailed.size();
    }/* Method that return number of subject failed*/

    public static int noOfSubjetsFailed(ArrayList<Integer> obj) {
        ArrayList<Integer> totalMarks = obj;
        ArrayList<Integer> dummmyMarksList = new ArrayList<>(totalMarks);
        ArrayList<Integer> totalSubjectsFailed = new ArrayList<>();
        ArrayList<Integer> finalTotalMarks = dummmyMarksList;
        totalMarks.forEach(mark -> {

            int indexOfMinValue = minValueIndex(finalTotalMarks);

            if (finalTotalMarks.get(indexOfMinValue) < 25) {
                totalSubjectsFailed.add(finalTotalMarks.get(indexOfMinValue));
                finalTotalMarks.remove(indexOfMinValue);
            }
        });
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

    /* Convert an HashMap reference-Object values into ArrayList*/
    public static ArrayList<Integer> convertObjValuesToArrayList(Object obj) {
        HashMap<String, Integer> map = (HashMap<String, Integer>) obj;
        Collection<Integer> values = map.values();
        ArrayList<Integer> list = new ArrayList<>(values);
        return list;
    }

    /* Convert an HashMap reference-Object keys into Set*/
    public static Set<String> convertObjKeysToSet(Object obj) {
        HashMap<String, Integer> map = (HashMap<String, Integer>) obj;
        Set<String> list = (Set<String>) map.keySet();
        return list;
    }
}
