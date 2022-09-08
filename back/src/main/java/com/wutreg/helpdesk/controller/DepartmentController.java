package com.wutreg.helpdesk.controller;

import com.wutreg.helpdesk.dto.DepartmentDTO;
import com.wutreg.helpdesk.model.Department;
import com.wutreg.helpdesk.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/departments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService service) {
        this.departmentService = service;
    }

    @GetMapping
    public List<DepartmentDTO> getAll() {
        return departmentService.getAll().stream()
            .map(DepartmentController::convertToDto) //TODO: надо вынести в MapStruct
            .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public DepartmentDTO getById(@PathVariable long id) {
        Department department = departmentService.getDepartment(id);
        return convertToDto(department);
    }

    @PostMapping
    public DepartmentDTO add(@RequestBody DepartmentDTO departmentDTO) {
        Department department = convertToEntity(departmentDTO);
        department = departmentService.save(department);
        return convertToDto(department);
    }

    @PutMapping
    // TODO: не работает
    public DepartmentDTO update(@RequestBody DepartmentDTO departmentDTO) {
        Department department = convertToEntity(departmentDTO);
        department = departmentService.save(department);
        return convertToDto(department);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable long id) {
        Department department = departmentService.getDepartment(id);
        if (Objects.isNull(department)) {
            String errorMessage = "There is no department with Id = " + id + " in Database";
            throw new RuntimeException(errorMessage); // TODO: нужен нормальный ExceptionHandler
        }

        departmentService.delete(department);
        return "Department with Id = " + id + " was delete";
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
