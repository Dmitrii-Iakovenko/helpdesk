package com.wutreg.helpdesk.controller;

import com.wutreg.helpdesk.dto.DepartmentDTO;
import com.wutreg.helpdesk.entity.Department;
import com.wutreg.helpdesk.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/departments")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService service) {
        this.departmentService = service;
    }

    @GetMapping
    public List<DepartmentDTO> getAll() {
        return departmentService.getAll().stream()
            .map(DepartmentController::convertToDto)
            .collect(Collectors.toList());
    }

//    @GetMapping("{id}")

    @PostMapping
    public DepartmentDTO add(@RequestBody DepartmentDTO departmentDTO) {
        Department department = convertToEntity(departmentDTO);
        department = departmentService.save(department);
        return convertToDto(department);
    }

    private static DepartmentDTO convertToDto(Department department) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setDepartment_id(department.getId());
        dto.setName(department.getName());
        Department parent = department.getParent();
        Long id = (parent != null) ? parent.getId() : 0L;
        dto.setParent_id(id);
        return dto;
    }

    private static Department convertToEntity(DepartmentDTO dto) {
        Department department = new Department();
        department.setId(dto.getDepartment_id());
        department.setName(dto.getName());
        department.setParent(null); // TODO: getDepartmentById
        return department;
    }
}
