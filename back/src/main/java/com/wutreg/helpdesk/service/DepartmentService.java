package com.wutreg.helpdesk.service;

import com.wutreg.helpdesk.entity.Department;
import com.wutreg.helpdesk.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record DepartmentService(DepartmentRepository repository) {

    public List<Department> getAll() {
        return repository.findAll();
    }

    public Department save(Department department) {
        return repository.save(department);
    }
}
