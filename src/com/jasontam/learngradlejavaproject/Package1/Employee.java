package com.jasontam.learngradlejavaproject.Package1;


import java.util.Optional;
import java.util.logging.Logger;


public class Employee {



    private String employee_name;
    private static Logger class_logger=Logger.getLogger(Employee.class.getName());

    public String getEmployee_name() {
        return employee_name;
    }
    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }


    public Employee(String name, Logger lg) {
        createEmployee(name,lg);
    }


    public Employee(String name) {
        createEmployee(name, null);
    }


    private void createEmployee(String name, Logger lg){

        Optional<Logger> logger = Optional.ofNullable(lg);
        //class_logger = logger.orElse(class_logger);
        if (lg!=null) class_logger=lg;
        class_logger.entering(getClass().getName(),"createEmployee");
        class_logger.info("logger is "+ class_logger.getName());
        setEmployee_name(name);

        class_logger.info("Created qan Employee named: " + name);
        class_logger.exiting(getClass().getName(),"createEmployee");


    }
}