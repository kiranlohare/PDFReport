package com.kiran.reportgenerator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.reportgenerator.entity.Student;
import com.kiran.reportgenerator.exception.StudentNotSavedException;
import com.kiran.reportgenerator.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	public StudentRepository getRepository() {
		return repository;
	}

	public void setRepository(StudentRepository repository) {
		this.repository = repository;
	}

	@Override
	public void downloadStudentReport(Integer studentId) {
		if (studentId != null) {
			List<Student> student = repository.findByStudentId(studentId);
		}
	}

	@Override
	public boolean saveStudent(Student student) {
		if (student != null) 
		{
			Student result = repository.save(student);
			if (result != null) 
			{
				return true;
			}
			else
			{
				throw new StudentNotSavedException("Student not saved please provide correct information : " + student);
			}
		}
		return false;
	}

	@Override
	public void removeStudentById(Integer id) {
		if(id!=null)
		{
			repository.deleteById(id);
		}
	}
}
