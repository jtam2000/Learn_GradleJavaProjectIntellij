package com.jasontam.learngradlejavaproject.Package1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter{

    @Override
    public String format(LogRecord record) {

        Date currentDateTime = new Date(record.getMillis());
        DateFormat dateFormat= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:sss");
        String dateTimeString = dateFormat.format(currentDateTime);

        String levelString = record.getLevel().getName();

        String messageString = record.getMessage();

        String threadIdString = new Integer(record.getThreadID()).toString();

        String rtn = String.format("[%s]:[%s]:[%s]:[thread:%s]\n",dateTimeString, levelString, messageString, threadIdString);

        return rtn;
    }
}


