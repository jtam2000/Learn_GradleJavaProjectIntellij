package com.jasontam.learngradlejavaproject.Package1;

import static java.lang.System.out;

public class Employee {



    private String employee_name;

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }


    public Employee(String name) {
        setEmployee_name(name);
        out.println("\nCreated an Employee named: " + name);
    }


}