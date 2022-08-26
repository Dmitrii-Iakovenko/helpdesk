package com.wutreg.helpdesk.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long employeeId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Long departmentId;
    private String jobPosition;
    private String workLocation;
    private String email;
    private String cityPhone;
    private String mobilePhone;
    private String localPhone;
}
