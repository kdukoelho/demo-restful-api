package com.rabbit.demorestfulapi.entities;

import com.rabbit.demorestfulapi.dto.EmployeeRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="tb_employees")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Employee {
	public Employee(EmployeeRequestDTO employeeRequestDTO){
		this.employeeName = employeeRequestDTO.employeeName();
		this.email = employeeRequestDTO.email();
		this.department = employeeRequestDTO.department();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String employeeName;
	private String email;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
}