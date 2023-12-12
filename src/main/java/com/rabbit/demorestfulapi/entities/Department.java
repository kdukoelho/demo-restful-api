package com.rabbit.demorestfulapi.entities;

import com.rabbit.demorestfulapi.dto.DepartmentRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="tb_departments")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String depName;

	public Department(DepartmentRequestDTO departmentRequestDTO){
		this.id = departmentRequestDTO.id();
		this.depName = departmentRequestDTO.name();
	}
}
