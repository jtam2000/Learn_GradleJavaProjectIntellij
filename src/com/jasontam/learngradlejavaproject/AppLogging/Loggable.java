package com.jasontam.learngradlejavaproject.AppLogging;

import java.util.logging.Logger;


public interface Loggable {

    AppLogger appLogger = AppLogger.getInstance();

    default Logger getAppLogger() {
        return appLogger.getAppLogger();
    }
}
