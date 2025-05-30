package me.chamodi.spring.sql.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import me.chamodi.spring.sql.models.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, String>{
    //JPQL
    @Query("SELECT name FROM Department")
    public List<String>getDeptNames();

    @Query("SELECT d FROM Department AS d WHERE d.name like %?1%")
    public List<Department>searchByName(String name);
}
