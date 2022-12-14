package com.wutreg.helpdesk.controller;

import com.wutreg.helpdesk.dto.EmployeeDTO;
import com.wutreg.helpdesk.model.Employee;
import com.wutreg.helpdesk.mapper.EmployeeMapper;
import com.wutreg.helpdesk.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public final class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> getAll() {
        List<Employee> employees = employeeService.getAll();
        return EmployeeMapper.INSTANCE.map(employees);
    }
}
