package com.jasontam.learngradlejavaproject.applogging;

import java.io.FileInputStream;
import java.util.Optional;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public final class AppLogger {

    private static final String LOG_CONFIGURATION_SYSTEM_PROPERTY_NAME = "java.util.logging.config.file";

    private static AppLogger ourInstance = new AppLogger();
    public static AppLogger getInstance() {
        return ourInstance;
    }
    private AppLogger(){}

    private static Logger defaultAppLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static Logger logger = null;


    public Logger getAppLogger() {
        return logger ==null ? defaultAppLogger : logger;
    }

    // Someone has to set this once in an application
    //The logger should be configured as a run parameter
    // like -Djava.util.logging.config.file=logging.properties
    public static Logger setLogger(String loggerName) {

        if (logger == null) logger = Logger.getLogger(loggerName);

        try {
            Optional<String> logConfigFile = Optional.ofNullable(System.getProperty(LOG_CONFIGURATION_SYSTEM_PROPERTY_NAME));

            if (logConfigFile.isPresent())
                LogManager.getLogManager().readConfiguration(new FileInputStream(logConfigFile.get()));
            else {
                logger.warning(String.format("Reading logger config property:%s%n",
                                        LOG_CONFIGURATION_SYSTEM_PROPERTY_NAME));
                logger.warning("log config file is null");
            }

            Handler fileHandler = new FileHandler();
            fileHandler.setFormatter(new LogFormatter());

            logger.addHandler(fileHandler);

        } catch (Exception e1) {
            logger.severe(String.format("unable to read system property for log file: %s",
                    LOG_CONFIGURATION_SYSTEM_PROPERTY_NAME));
            logger.severe(String.format("%s%n", e1.toString()));
        }

        return logger;

    }

}