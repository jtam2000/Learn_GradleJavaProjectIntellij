package com.jasontam.learngradlejavaproject.test.LogFormatterTestPackage;

import com.jasontam.learngradlejavaproject.MainApplication.MainApplication;
import com.jasontam.learngradlejavaproject.Package1.LogFormatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static com.jasontam.learngradlejavaproject.MainApplication.MainApplication.appLogger;

public class LogFormatterTest {

    @Test
    public void test_logMessageHasAllParts() {

        //Setup
        LogRecord sampleLog = new LogRecord(Level.INFO, "This is test message 83123");
        LogFormatter logFormat= new LogFormatter();

        //Actual
        String actualString=logFormat.format(sampleLog);


        //Expecting
        Date currentDateTime = new Date(sampleLog.getMillis());
        DateFormat dateFormat= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:sss");
        String dateTimeString = dateFormat.format(currentDateTime);

        String levelString = sampleLog.getLevel().getName();

        String messageString = sampleLog.getMessage();

        String threadIdString = new Integer(sampleLog.getThreadID()).toString();


        //5 Logger_name
        String loggerName = sampleLog.getLoggerName();

        //6 Class Name
        String className = sampleLog.getSourceClassName();

        //7 Method Name
        String methodName = sampleLog.getSourceMethodName();

        String expectedString= String.format("[%s]:[%s]:[%s]:[thread:%s]:[logger:%s]:[class:%s]:[func:%s]\n",
                dateTimeString, levelString, messageString, threadIdString, loggerName, className, methodName);

        assertEquals(expectedString,actualString);

    }

}