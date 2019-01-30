package com.stats.app;

import java.util.HashMap;
import java.util.Random;

enum Subject {
    JAVA, ANGULAR, NODEJS, REACT, VUE, IONIC, ANDROID, PYTHON
}

public class GenerateMarks {
    private static Random random = new Random();

    public void generateStudentMarks() {
        HashMap<String, Integer> m = new HashMap<>();
        int randomNumber = random.nextInt(7);
        for (int i = 0; i < 3; i++) {
            StudentDetails si = new StudentDetails(i, "chaitanya", m);
        }
    }
}
