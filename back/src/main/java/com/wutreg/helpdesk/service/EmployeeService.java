package com.wutreg.helpdesk.service;

import com.wutreg.helpdesk.entity.Employee;
import com.wutreg.helpdesk.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record EmployeeService(EmployeeRepository employeeRepository) {

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

}
