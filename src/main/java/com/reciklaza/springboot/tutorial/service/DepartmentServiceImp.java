package com.reciklaza.springboot.tutorial.service;

import com.reciklaza.springboot.tutorial.entity.Department;
import com.reciklaza.springboot.tutorial.error.DepartmentNotFoundException;
import com.reciklaza.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartmentsList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentByID(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department depDB = departmentRepository.findById(id).get();
        if (Objects.nonNull(department.getDepartmentName()) && !department.getDepartmentName().isBlank()) {
            depDB.setDepartmentName(department.getDepartmentName());

        }
        if (Objects.nonNull(department.getDepartmentAddress()) && !department.getDepartmentAddress().isBlank()) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());

        }
        if (Objects.nonNull(department.getDepartmentCode()) && !department.getDepartmentCode().isBlank()) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
