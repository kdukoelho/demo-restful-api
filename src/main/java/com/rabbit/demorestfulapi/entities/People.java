package com.rabbit.demorestfulapi.entities;

import com.rabbit.demorestfulapi.dto.PeopleRequestDTO;
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

@Table(name="tb_peoples")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class People {
	public People(PeopleRequestDTO peopleRequestDTO){
		this.peopleName = peopleRequestDTO.peopleName();
		this.email = peopleRequestDTO.email();
		this.department = peopleRequestDTO.department();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String peopleName;
	private String email;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
}
