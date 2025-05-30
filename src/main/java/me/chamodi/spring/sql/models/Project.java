package me.chamodi.spring.sql.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
    @Id
    private String projectId;
    @Column(nullable = false)
    private String name;
    private long totalcost;
    @ManyToMany
    @JoinTable(name="project_assignments", 
    joinColumns = @JoinColumn(name="pro_id"),
    inverseJoinColumns = @JoinColumn(name="emp_id"))

    public long getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(long totalcost) {
        this.totalcost = totalcost;
    }
    @ManyToMany
    private List<Employee> employees;

    
    public Project(String projectId, String name, long totalcost, List<Employee> employees) {
        this.projectId = projectId;
        this.name = name;
        this.totalcost=totalcost;
        this.employees = employees;
    }

    public String getProjectId() {
        return projectId;
    }
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    
}
