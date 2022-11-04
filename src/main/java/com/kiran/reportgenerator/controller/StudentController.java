package com.kiran.reportgenerator.controller;

import java.util.InputMismatchException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.reportgenerator.entity.Student;
import com.kiran.reportgenerator.exception.StudentNotFoundException;
import com.kiran.reportgenerator.repository.StudentRepository;
import com.kiran.reportgenerator.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	private static final Logger log=LoggerFactory.getLogger(StudentController.class); 
	@Autowired
	private StudentService service;

	@GetMapping("/std/{id}")
	public ResponseEntity<String> downloadReport(@PathVariable Integer id) {
		log.info ("Inside download report controller method");
		try {
			if (id != null) {
				service.downloadStudentReport(id);
				log.info ("Executed method successfull");
				return ResponseEntity.status(HttpStatus.OK).body("File Downloaded check downloads");
				
			} else {
				log.info ("given student id is null");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide student id to find user");
			}
		} catch (StudentNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
//	@Autowired
//	private StudentRepository repository;
//	@GetMapping("/std/{id}")
//	public ResponseEntity<String> downloadReport(@PathVariable Integer id) {
//		log.info ("Inside download report controller method");
//		try {
//			if (id != null) {
//				//service.downloadStudentReport(id);
//				Student orElse = repository.findById(id).orElse(null);
//				log.info ("Executed method successfull");
//				return ResponseEntity.status(HttpStatus.OK).body("File Downloaded check downloads");
//				
//			} else {
//				log.info ("given student id is null");
//				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide student id to find user");
//			}
//		} catch (StudentNotFoundException e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//		}
//	}
//	

	@PostMapping("/addstd")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		log.info ("Inside addStudent method");
		try {
			if (student != null) {
				boolean b = service.saveStudent(student);
				if (b == true) {
					log.info ("Added student");
					return ResponseEntity.status(HttpStatus.OK).body("Student added successfully...!");
				} else {
					log.info ("Database error");
					return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Database error");
				}
			} else {
				log.info ("There is a null value in input");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enter correct values...!");
			}
		} catch (InputMismatchException e) {
			log.info ("Input was missmatch required integer value");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (StudentNotFoundException e) {
			log.info ("Given student id not found in database");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with the given id");
		}
	}
	@DeleteMapping("/delstd/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id)
	{
		try
		{
			service.removeStudentById(id);
			log.info ("Student removed");
			return ResponseEntity.status(HttpStatus.OK).body("Deleted student successfully : "+ id);
		}
		catch (StudentNotFoundException e) {
			log.info ("given student id is not found in database");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		catch (InputMismatchException e) {
			log.info ("Input was missmatch required integer value");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
