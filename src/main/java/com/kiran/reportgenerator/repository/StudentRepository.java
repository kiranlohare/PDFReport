package com.kiran.reportgenerator.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.kiran.reportgenerator.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	// Used to remove student from db
	
	Optional<Student> findById(Integer studentId);
	
	// Deletes student by given entity
	void deleteById(Integer id);
}