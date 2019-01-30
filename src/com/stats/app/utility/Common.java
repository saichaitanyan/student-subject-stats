package com.stats.app.utility;

import java.util.*;

public class Common {

    public Common(ArrayList<HashMap<String, Object>> list) {
        System.out.println(list);

    }

    private static ArrayList<HashMap<String, Object>> list = new ArrayList<>();
    private static Set<String> keys = new HashSet<>();

    public static void calculateMinMaxAvg() {

        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map = list.get(i);
//            keys = map.keySet();
//            System.out.println("!!!" + list.get(i));
        }
    }

    public static ArrayList<HashMap<String, Object>> getList() {
        return list;
    }

    public static void setList(ArrayList<HashMap<String, Object>> arrayList) {
        list = arrayList;
//        System.out.println("student data: "+arrayList);
        calculateMinMaxAvg();
    }
}
