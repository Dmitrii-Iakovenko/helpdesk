package com.wutreg.helpdesk.repository;

import com.wutreg.helpdesk.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
