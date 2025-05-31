package me.chamodi.spring.sql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.chamodi.spring.sql.models.Employee;
import me.chamodi.spring.sql.services.EmployeeService;

@RestController
@RequestMapping("/emp")

public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/salaryRange")
    public ResponseEntity<List<Employee>>getEmpInSalaryRange(){
        return new ResponseEntity<List<Employee>>(service.getEmployeesInSalaryRange(), HttpStatus.OK);
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<List<Employee>>getEmployeesInDepartment(@PathVariable("id") String id){
    //     return new ResponseEntity<List<Employee>>(service.getEmployeesInDepartment(id), HttpStatus.OK);
    // }

    // @GetMapping("/youngestFemale")
    // public ResponseEntity <Employee> getYoungestFemale(){
    //     return new ResponseEntity <Employee>(service.getYoungestFemale(), HttpStatus.OK);
    // }
}
