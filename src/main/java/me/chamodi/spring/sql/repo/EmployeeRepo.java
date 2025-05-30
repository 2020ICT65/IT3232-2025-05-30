package me.chamodi.spring.sql.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import me.chamodi.spring.sql.models.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {
    @Query("SELECT e FROM Employee e WHERE e.salary > 70000 AND e.salary < 90000")
    public List<Employee> getEmployeeInSalaryRange();

    @Query("SELECT e FROM Employee e WHERE e.department_dep_id = ?1")
    public List<Employee> getEmployeesInDepartment(String dept_id);

    @Query("SELECT e FROM Employee e WHERE e.gender = female ORDER BY e.age DESC LIMIT 1")
    public Employee getYoungestFemale();
}
