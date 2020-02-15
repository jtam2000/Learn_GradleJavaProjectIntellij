package com.jasontam.learngradlejavaproject.MainApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.jasontam.learngradlejavaproject.AppLogging.AppLogger;
import com.jasontam.learngradlejavaproject.Package1.Employee;
import com.jasontam.learngradlejavaproject.AppLogging.LogFormatter;


public class MainApplication {

    private static AppLogger appLogger = AppLogger.getInstance();


    private static Logger localLogger = null;

    public static void main(String[] args) {

        appLogger.setAppLogger(
                    MainApplication.class.getName(),
                "logging.properties",
                "./MainApp.log.txt",
                200,
                5);

        localLogger = appLogger.getAppLogger();

        Date today = Calendar.getInstance().getTime();

        localLogger.info("Hello world from GradleBuild Application Main Class");
        localLogger.info("Execution time:=>" + today.toString());

        Employee ee = new Employee("Jason Tam");
        Employee ee_without_looger = new Employee("Linda Tam");

    }
}
