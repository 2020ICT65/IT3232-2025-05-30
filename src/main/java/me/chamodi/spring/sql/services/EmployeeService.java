package me.chamodi.spring.sql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import me.chamodi.spring.sql.models.Employee;
import me.chamodi.spring.sql.repo.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo repo;

    public List<Employee> getEmployeesInSalaryRange() {
        if (repo.getEmployeeInSalaryRange().isEmpty()) {
            throw new EntityNotFoundException("Department Not Found!");
        }
        return repo.getEmployeeInSalaryRange();
    }

    public List<Employee> getEmployeesInDepartment(String deptid) {
        if (repo.getEmployeesInDepartment(deptid).isEmpty()) {
            throw new EntityNotFoundException("Department Not Found!");
        }
        return repo.getEmployeesInDepartment(deptid);
    }

    public Employee getYoungestFemale() {
        if (repo.getYoungestFemale()!= null){
            throw new EntityNotFoundException("Department Not Found!");
        }
        return repo.getYoungestFemale();
    }
}
