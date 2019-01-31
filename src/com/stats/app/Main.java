package com.stats.app;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        StudentDetails.displayStudentDetails();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter to see Student status");
        String s = scanner.nextLine();

        if (s.equals("")) {
            StudentStats studentStats = new StudentStats();
        }
    }

}
