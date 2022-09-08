package com.wutreg.helpdesk.repository;

import com.wutreg.helpdesk.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
