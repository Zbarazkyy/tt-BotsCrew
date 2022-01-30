package com.example.ttbotscrew.service.impl;

import com.example.ttbotscrew.model.Department;
import com.example.ttbotscrew.repository.DepartmentRepository;
import com.example.ttbotscrew.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
