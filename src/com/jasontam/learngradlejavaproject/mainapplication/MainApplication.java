package com.jasontam.learngradlejavaproject.mainapplication;

import java.util.*;
import java.util.logging.Logger;

import com.jasontam.learngradlejavaproject.applogging.AppLogger;
import com.jasontam.learngradlejavaproject.package1.Employee;


public class MainApplication {

    private static AppLogger appLogger = AppLogger.getInstance();

    public static void main(String[] args) {


        Logger localLogger;

        AppLogger.setLogger(MainApplication.class.getName());

        localLogger = appLogger.getAppLogger();

        Date today = Calendar.getInstance().getTime();

        localLogger.info("Hello world from Gradle Build Application Main Class");
        localLogger.info("Application Execution time:=>" + today.toString());

        List<Employee> list = Arrays.asList(new Employee("Jason Tam"), new Employee("Linda Tam"));

        for (Employee ee:list) {
            localLogger.info(ee.getEmployee_name());
        }


    }
}
