package com.reciklaza.springboot.tutorial.controller;

import com.reciklaza.springboot.tutorial.entity.Department;
import com.reciklaza.springboot.tutorial.error.DepartmentNotFoundException;
import com.reciklaza.springboot.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService service;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return service.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        LOGGER.info("Inside getDepartments of DepartmentController");
        return service.getDepartmentsList();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        LOGGER.info("Inside getById of DepartmentController");
        return service.getDepartmentByID(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id) {
        LOGGER.info("Inside deleteDepartmentById of DepartmentController");
        service.deleteDepartmentById(id);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long id,
                                       @RequestBody Department department) {
        LOGGER.info("Inside updateDepartment of DepartmentController");
        return service.updateDepartment(id, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName) {
        LOGGER.info("Inside getDepartmentByName of DepartmentController");
        return service.getDepartmentByName(departmentName);
    }


}
