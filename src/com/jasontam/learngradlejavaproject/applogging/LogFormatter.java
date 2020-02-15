package com.jasontam.learngradlejavaproject.applogging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter {

    //Example: 02/13/2020 18:29:38:038
    private static final String DEFAULT_DATE_FORMAT = "MM/dd/yyyy HH:mm:ss:sss";

    //1 date, 2 level, 3 message, 4 thread_id, 5 logger_name, 6 Class_name, 7 Method_Name
    private static final String DEFAULT_OUTPUT_FORMAT = "[%s]:[%s]:[%s]:[thread:%s]:[logger:%s]:[class:%s]:[func:%s]%n";


    @Override
    public String format(LogRecord record) {

        //1 Log date
        Date currentDateTime = new Date(record.getMillis());
        DateFormat logDateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        String dateTimeString = logDateFormat.format(currentDateTime);

        //2 log level name
        String levelString = record.getLevel().getName();

        //3 log message
        String messageString = record.getMessage();

        //4 log thread id
        String threadIdString = Integer.toString(record.getThreadID());

        //5 Logger_name
        String loggerName = record.getLoggerName();

        //6 Class Name
        String className = record.getSourceClassName();

        //7 Method Name
        String methodName = record.getSourceMethodName();

        return String.format(DEFAULT_OUTPUT_FORMAT,
                dateTimeString,
                levelString,
                messageString,
                threadIdString,
                loggerName,
                className,
                methodName);

    }
}


