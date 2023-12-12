package com.rabbit.demorestfulapi.repository;

import com.rabbit.demorestfulapi.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRespository extends JpaRepository<Long, Department> {
}
