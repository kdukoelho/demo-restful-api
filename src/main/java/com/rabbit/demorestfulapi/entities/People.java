package com.rabbit.demorestfulapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="tb_peoples")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class People {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String peopleName;
	private String email;
	
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;
}
