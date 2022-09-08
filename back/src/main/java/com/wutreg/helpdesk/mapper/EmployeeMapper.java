package com.wutreg.helpdesk.mapper;

import com.wutreg.helpdesk.dto.EmployeeDTO;
import com.wutreg.helpdesk.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "employeeId", source = "id")
    @Mapping(target = "departmentId", source = "department")
    EmployeeDTO map(Employee employee);

    @Mapping(target = "id", source = "employeeId")
    @Mapping(target = "department", source = "departmentId")
    Employee map(EmployeeDTO employeeDTO);



    List<EmployeeDTO> map(List<Employee> employees);
//    List<Employee>    map(List<EmployeeDTO> employeesDTO);
}
