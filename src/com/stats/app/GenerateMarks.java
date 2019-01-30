package com.stats.app;

import java.util.*;
import java.util.stream.Collectors;

enum Subject {
    JAVA, ANGULAR, NODEJS, REACT, VUE, IONIC, ANDROID, PYTHON
}

public class GenerateMarks {
    private static Random random = new Random();
    private static HashMap<String, Integer> map = new HashMap<>();
    private static final Subject[] subjectsList = Subject.values();
//    private static final ArrayList<Integer> marks = new ArrayList<>();
//    private static final Set<String> subjectName = new HashSet<>();

    public static HashMap<String, Integer> generateStudentMarks() {
        for (int i = 0; i < 5; i++) {
            int selectRandomSubject = random.nextInt(7);
            int selectRandomMarks = random.nextInt(100);

            String subjectName = String.valueOf(subjectsList[selectRandomSubject]);
            map.put(subjectName, selectRandomMarks);
        }
        return map;
    }
}
