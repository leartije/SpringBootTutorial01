package com.reciklaza.springboot.tutorial.repository;

import com.reciklaza.springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


    Department findByDepartmentNameIgnoreCase(String departmentName);
}
