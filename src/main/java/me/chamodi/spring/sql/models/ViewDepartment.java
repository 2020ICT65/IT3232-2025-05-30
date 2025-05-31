package me.chamodi.spring.sql.models;

import java.util.Date;
import java.util.List;

public class ViewDepartment extends Department{
    private int empcount;

    public ViewDepartment(String depId, String name, Date established, List<Employee> employees, int empcount) {
        super(depId, name, established, employees);
        this.empcount = empcount;
    }

    public ViewDepartment(int empcount) {
        this.empcount = empcount;
    }

    public ViewDepartment() {
        
    }
   
}

