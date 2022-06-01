package com.reciklaza.springboot.tutorial.service;

import com.reciklaza.springboot.tutorial.entity.Department;
import com.reciklaza.springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);
    List<Department> getDepartmentsList();
    Department getDepartmentByID(Long id) throws DepartmentNotFoundException;
    void deleteDepartmentById(Long id);
    Department updateDepartment(Long id, Department department);

    Department getDepartmentByName(String departmentName);
}
