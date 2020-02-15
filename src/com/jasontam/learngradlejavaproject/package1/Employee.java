package com.jasontam.learngradlejavaproject.package1;


import com.jasontam.learngradlejavaproject.applogging.Loggable;


public class Employee implements Loggable {



    private String employee_name;

    public String getEmployee_name() {
        return employee_name;
    }
    public void setEmployee_name(String employee_name) {

        this.employee_name = employee_name;
        getAppLogger().info("Set an Employee named " + employee_name);
    }



    public Employee(String name) {
        createEmployee(name);
    }


    private void createEmployee(String name){

        getAppLogger().entering(getClass().getName(),"createEmployee");
        setEmployee_name(name);

        getAppLogger().info("Created an Employee named: " + name);
        getAppLogger().exiting(getClass().getName(),"createEmployee");


    }
}