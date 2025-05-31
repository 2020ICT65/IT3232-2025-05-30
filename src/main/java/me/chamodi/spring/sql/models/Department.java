package me.chamodi.spring.sql.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
    @Id
    @Column(name="dep_id")
    private String depId;
    @Column(nullable = false)
    private String name;
    private Date established;
    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
    
    public Department(){

    }

    public Department(String depId, String name, Date established, List<Employee> employees) {
        this.depId = depId;
        this.name = name;
        this.established = established;
        this.employees = employees;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEstablished() {
        return established;
    }

    public void setEstablished(Date established) {
        this.established = established;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    
}

