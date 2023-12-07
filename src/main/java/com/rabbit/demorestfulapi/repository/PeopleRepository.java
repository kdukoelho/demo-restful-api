package com.rabbit.demorestfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rabbit.demorestfulapi.entities.People;

public interface PeopleRepository extends JpaRepository<People, Long>{
	
}
