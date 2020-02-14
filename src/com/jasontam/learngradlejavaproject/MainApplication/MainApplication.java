package com.jasontam.learngradlejavaproject.MainApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.jasontam.learngradlejavaproject.Package1.Employee;
import com.jasontam.learngradlejavaproject.Package1.LogFormatter;


public class MainApplication {

    public static Logger appLogger = Logger.getLogger(MainApplication.class.getName());

    public static void main(String[] args) {

        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
            Handler fileHandler = new FileHandler("./MainApp.log.txt", 200, 5);
            fileHandler.setFormatter(new LogFormatter());
            appLogger.addHandler(fileHandler);

        } catch (SecurityException | IOException e1){
            e1.printStackTrace();
        }

        Date today = Calendar.getInstance().getTime();

        appLogger.info("Hello world from GradleBuild Application Main Class");
        appLogger.info("Execution time:=>" + today.toString());

        Employee ee = new Employee("Jason Tam", appLogger);

    }
}
