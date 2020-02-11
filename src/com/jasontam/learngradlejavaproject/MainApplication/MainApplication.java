package com.jasontam.learngradlejavaproject.MainApplication;

import java.util.Calendar;
import java.util.Date;

import com.jasontam.learngradlejavaproject.Package1.Employee;

import static java.lang.System.out;

public class MainApplication {

    public static void main(String[] args) {
        Date today = Calendar.getInstance().getTime();


        out.println("\nHello world from GradleBuild Application Main Class:");
        out.println("Execution time:=>" + today.toString());

        Employee ee = new Employee("Jason Tam");

    }
}
