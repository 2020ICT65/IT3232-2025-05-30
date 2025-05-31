package me.chamodi.spring.sql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.persistence.EntityNotFoundException;
import me.chamodi.spring.sql.models.Department;
import me.chamodi.spring.sql.models.ViewDepartment;
import me.chamodi.spring.sql.repo.DepartmentRepo;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo repo;

    public List<Department> getDepts() {
        return repo.findAll();
    }

    public Department getDept(String id) {
        if (repo.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Department Not Found!");
        }
        return repo.findById(id).get();
    }

    public List<String>getDepartmentnames() {
        if (repo.getDeptNames().isEmpty()) {
            throw new EntityNotFoundException("Department Not Found!");
        }
        return repo.getDeptNames();
    }

    public List<Department> searchDept(String name) {
        if (repo.searchByName(name).isEmpty()) {
            throw new EntityNotFoundException("Department Not Found!");
        }
        return repo.searchByName(name);
    }

    public List<String> countEmployees(){
        if(repo.countEmployees().isEmpty()){
            throw new EntityNotFoundException("Department Not Found!");
        }
        return repo.countEmployees();
    }

    public int EmployeeCount(String depId){
        if(repo.employeeCount(depId) == 0){
            throw new EntityNotFoundException("Department Not Found!");
        }
        return repo.employeeCount(depId);
    }

    public Department addDept(Department department) {
        if(repo.findById(department.getDepId()).isPresent()){
            throw new DuplicateKeyException("Department Already existing!");
        }
        repo.save(department);
        return department;
    }

    public ViewDepartment getEmplCountView(String id){
        if(repo.findById(id).isEmpty()){
            throw new EntityNotFoundException("Department Not Found!");
        }
        Department department = repo.findById(id).get();
        ViewDepartment viewDepartment = new ViewDepartment(department.getDepId(), department.getName(), department.getEstablished(), department.getEmployees(), EmployeeCount(id));
        return viewDepartment;
    }
    public String updateDept(@PathVariable String id, @RequestBody Department department) {
        if (repo.findById(id).isEmpty()) {
            return "Couldn't find the department!";
        }
        repo.save(department);
        return "Updated Successfully!";
    }

    public String deleteDept(@PathVariable("id") String id) {
        if (repo.findById(id).isEmpty()) {
            return "Couldn't find the department!";
        }
        repo.deleteById(id);
        ;
        return "Department Deleted Successfully!";
    }
}
