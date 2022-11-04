package com.kiran.reportgenerator.service;

import com.kiran.reportgenerator.entity.Student;

public interface StudentService {
	// Used to remove student from db
		
		void downloadStudentReport(Integer studentId);
		
		//Saves student Record
		boolean saveStudent(Student student);
		
		// Deletes student by given entity
		void removeStudentById(Integer id);
}
