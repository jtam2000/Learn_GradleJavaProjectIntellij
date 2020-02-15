package com.jasontam.learngradlejavaproject.applogging;

import java.util.logging.Logger;


public interface Loggable {

    default Logger getAppLogger() {
        return AppLogger.getInstance().getAppLogger();
    }
}
