package com.jasontam.learngradlejavaproject.AppLogging;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

final public class AppLogger {

    private static AppLogger ourInstance = new AppLogger();

    public static AppLogger getInstance() {
        return ourInstance;
    }

    private static Logger defaultAppLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static Logger  appLogger = null; // Someone has to set this once in an application

    private AppLogger(){}

    public Logger getAppLogger() {
        return appLogger==null ? defaultAppLogger : appLogger;
    }

    //The logger should be configured as a run parameter
    // like -Djava.util.logging.config.file=myfile
    public void setAppLogger(String loggerName) {

        if (appLogger==null)
            appLogger=Logger.getLogger(loggerName);

        try {
            Handler fileHandler = new FileHandler();
            fileHandler.setFormatter(new LogFormatter());
            appLogger.addHandler(fileHandler);

        } catch (SecurityException | IOException e1){
            e1.printStackTrace();
        }

    }


    @Deprecated
    //Requires: Set once per application, once it has been set, it can not be changed per Application
    public void setAppLogger(String loggerName,
                             String logConfigFile,
                             String logOutputFileName,
                             int logSizeRotateLimitInBytes,
                             int numLogFilesToRotate) {

        if (appLogger==null)
            appLogger=Logger.getLogger(loggerName);

        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream(logConfigFile));
            Handler fileHandler = new FileHandler(logOutputFileName, logSizeRotateLimitInBytes, numLogFilesToRotate);
            fileHandler.setFormatter(new LogFormatter());
            appLogger.addHandler(fileHandler);

        } catch (SecurityException | IOException e1){
            e1.printStackTrace();
        }

    }

}
