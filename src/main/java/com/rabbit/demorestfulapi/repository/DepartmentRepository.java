package com.rabbit.demorestfulapi.repository;

import com.rabbit.demorestfulapi.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
