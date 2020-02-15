package com.jasontam.learngradlejavaproject.test.EmployeeTestPackage;


import com.jasontam.learngradlejavaproject.AppLogging.AppLogger;
import com.jasontam.learngradlejavaproject.Package1.Employee;
import junit.framework.TestCase;

import java.util.logging.Logger;


public class EmployeeTest extends TestCase {

    private static AppLogger app=AppLogger.getInstance();

    private static Logger localLogger = null;

    @Override
    protected void setUp() {

        app.setAppLogger(EmployeeTest.class.getName());

        localLogger = app.getAppLogger();
    }


    public void testEmployee_get_employee_name() {

        localLogger.info("Start testEmployee_get_employee_name");

        //Given
        final String employee_name = "Jason Tam";
        final Employee ee = new Employee(employee_name);

        //When
        //Intentional No Op

        //Then
        assertEquals(ee.getEmployee_name(), employee_name);
        app.getAppLogger().info("End testEmployee_get_employee_name");
    }

    public void testEmployee_set_employee_name(){

        localLogger.info("Start Running testEmployee_set_employee_name");

        //Given
        final String old_employee_name = "Last Name, First Name";
        final Employee ee = new Employee(old_employee_name);

        //When
        final String new_employee_name = "Jason Tam";
        ee.setEmployee_name(new_employee_name);

        //Then
        assertEquals(ee.getEmployee_name(), new_employee_name);
        localLogger.info("End testEmployee_set_employee_name");
    }


}