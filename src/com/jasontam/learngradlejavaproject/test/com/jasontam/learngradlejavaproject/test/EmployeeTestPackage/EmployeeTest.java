package com.jasontam.learngradlejavaproject.test.EmployeeTestPackage;

import com.jasontam.learngradlejavaproject.Package1.Employee;
import org.junit.Test;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    @Test
    public void testEmployee_get_employee_name() {

        out.println("Start testEmployee_get_employee_name");

        //Given
        final String employee_name = "Jason Tam";
        final Employee ee = new Employee(employee_name);

        //When
        //Intentional No Op

        //Then
        assertEquals(ee.getEmployee_name(), employee_name);
        out.println("End testEmployee_get_employee_name");
    }

    @Test
    public void testEmployee_set_employee_name(){

        out.println("Start Running testEmployee_set_employee_name");

        //Given
        final String old_employee_name = "Last Name, First Name";
        final Employee ee = new Employee(old_employee_name);

        //When
        final String new_employee_name = "Jason Tam";
        ee.setEmployee_name(new_employee_name);

        //Then
        assertEquals(ee.getEmployee_name(), new_employee_name);
        out.println("End testEmployee_set_employee_name");
    }


}