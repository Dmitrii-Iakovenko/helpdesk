package com.wutreg.helpdesk.service;

import com.wutreg.helpdesk.model.Department;
import com.wutreg.helpdesk.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record DepartmentService(DepartmentRepository repository) {

    public List<Department> getAll() {
        return repository.findAll();
    }

    // TODO: тупые названия
    public Department getDepartment(long id) {
        return repository.getReferenceById(id);
    }

    public Department save(Department department) {
        return repository.save(department);
    }

    public void delete(Department department) {
        repository.delete(department);
    }
}
