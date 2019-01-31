package com.stats.app;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        // Displaying the Student name along with respective marks
        StudentDetails.displayStudentDetails();
        /*
         *   Scanner to read the input data
         * */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter to see Student status");
        String s = scanner.nextLine();      // To read the input type of String

        /*
         *  Check the condition for empty String
         * */
        if (s.equals("")) {
            StudentStats studentStats = new StudentStats();
        }
    }

}
