package me.chamodi.spring.sql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.chamodi.spring.sql.models.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, String>{

}
