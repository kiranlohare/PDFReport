package com.kiran.reportgenerator.service;

import java.util.InputMismatchException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.reportgenerator.entity.Student;
import com.kiran.reportgenerator.exception.StudentNotFoundException;
import com.kiran.reportgenerator.exception.StudentNotSavedException;
import com.kiran.reportgenerator.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	private static final Logger log=LoggerFactory.getLogger(StudentServiceImpl.class);
	private StudentRepository repository;
	private PdfFileGenerator fileGenerator;
	// default constructor

	public StudentServiceImpl() {
	}

	// parameterize constructor to initialize the beans}
	@Autowired
	public StudentServiceImpl(StudentRepository repository, PdfFileGenerator fileGenerator) {
		super();
		this.repository = repository;
		this.fileGenerator = fileGenerator;
	}

	/**
	 * this method find the given id in the database if value present in the
	 * database then internally calls the pdfFileGenerator() method of class
	 * PdfFileGenerator and downloads the report,
	 * 
	 * @param must not be {@literal null}
	 * @throws StudentNotFoundException if {@literal id} is {@literal null}.
	 */
	@Override
	public void downloadStudentReport(Integer studentId) {
		if (studentId != null) {
			Student student = repository.findById(studentId)
					.orElseThrow(() -> new StudentNotFoundException("Student not found with given id : " + studentId));
			
			fileGenerator.pdfFileGenrator(student);
		}
	}

	/**
	 * this method stores the given student object is not null
	 * 
	 * @param student must not be {@literal null}
	 * @throws StudentNotFoundException if {@literal student} is
	 *                                  {@literal NotFound}. if any issue occurs
	 *                                  internally
	 * @throws IncorrectInputException  if {@literal student} is {@literal null}
	 */
	@Override
	public boolean saveStudent(Student student) {
		if (student != null) {
			Student result = repository.save(student);
			if (result != null) {
				return true;
			} else {
				log.info ("Given student not saved");
				throw new StudentNotSavedException("Student not saved please provide correct information : ");
			}
		} else {
			log.info ("Required student values entered wrong info");
			throw new InputMismatchException("Please Enter correct values please re check and enter values ");
		}
	}

	/**
	 * this method removes the given student from the database
	 * 
	 * @param studentid must not be {@literal null}
	 * @throws StudentNotFoundException if {@literal student} is
	 *                                  {@literal NotFound}.
	 */
	@Override
	public void removeStudentById(Integer studentId) {
		if (studentId != null) {
			Student student = repository.findById(studentId).orElse(null);
			if (student != null) {
				repository.deleteById(studentId);
			} else {
				throw new StudentNotFoundException("Student not found with the given id "+studentId);
			}
		}
		else
		{
			log.info ("required value is integer intered value is"+studentId);
			throw new InputMismatchException("please enter correct student id : "+studentId);
		}
	}
}