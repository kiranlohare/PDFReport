 package com.kiran.reportgenerator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.PostConstruct;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.kiran.reportgenerator.entity.FinalTerm;
import com.kiran.reportgenerator.entity.FirstTerm;
import com.kiran.reportgenerator.entity.SecondTerm;
import com.kiran.reportgenerator.entity.Student;
import com.kiran.reportgenerator.repository.StudentRepository;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:/application-junit.properties")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

	//private static final Logger log= LoggerFactory.getLogger(StudentControllerTest.class);
	
	@Autowired
	private StudentRepository repository;
	
	
	private RequestSpecification requestSpecification;
	
	@LocalServerPort
	private int port;
	
	@PostConstruct
	public void initRequestSpecification()
	{
		final RequestSpecBuilder builder=new RequestSpecBuilder();
		requestSpecification = builder.setBaseUri("http://localhost:"+port+"/student")
				.setContentType(ContentType.JSON).build();
	}
	
	@Before
	public void init()
	{
		repository.deleteAll();
	}
	
	
	@Test
	public void testaddStudent()
	{
		//Given
		Student student=new Student();
		
		student.setStudentName("Kiran");
		student.setStudentStandard(12);
		FirstTerm one=new FirstTerm();
		SecondTerm two = new SecondTerm();
		FinalTerm finalTerm = new FinalTerm();
		
		student.setFinalTerm(finalTerm);
		student.setSecondTerm(two);
		student.setFirstTerm(one);
		
		student.getFinalTerm().setMarathiMarks(55);
		student.getSecondTerm().setMarathiMarks(70);
		student.getFinalTerm().setMarathiMarks(75);
		student.getFirstTerm().setHindiMarks(70);
		student.getSecondTerm().setHindiMarks(60);
		student.getFinalTerm().setHindiMarks(55);
		student.getFirstTerm().setEnglishMarks(60);
		student.getSecondTerm().setEnglishMarks(55);
		student.getFinalTerm().setEnglishMarks(52);
		
		repository.save(student);
		
		//When
		final ValidatableResponse response = RestAssured.given(requestSpecification).basePath("/std/1")
				.when().get().then();
		
		//then
		assertEquals(HttpStatus.OK.value(), response.extract().statusCode());
		
	}
	@Test
	public void testdownloadReport()
	{
		//Given
		Student student=new Student();
		
		student.setStudentName("Kiran");
		student.setStudentStandard(12);
		FirstTerm one=new FirstTerm();
		SecondTerm two = new SecondTerm();
		FinalTerm finalTerm = new FinalTerm();
		
		student.setFinalTerm(finalTerm);
		student.setSecondTerm(two);
		student.setFirstTerm(one);
		
		student.getFinalTerm().setMarathiMarks(55);
		student.getSecondTerm().setMarathiMarks(70);
		student.getFinalTerm().setMarathiMarks(75);
		student.getFirstTerm().setHindiMarks(70);
		student.getSecondTerm().setHindiMarks(60);
		student.getFinalTerm().setHindiMarks(55);
		student.getFirstTerm().setEnglishMarks(60);
		student.getSecondTerm().setEnglishMarks(55);
		student.getFinalTerm().setEnglishMarks(52);
		
		repository.save(student);
		
		//When
		final ValidatableResponse response = RestAssured.given(requestSpecification)
				.basePath("/std/{id}").pathParam("id", student.getStudentId())
				.when().get().then();
		
		//then
		assertEquals(HttpStatus.OK.value(), response.extract().statusCode());
	}
	@Test
	public void testDeleteStudent()
	{
		//Given
		Student student=new Student();
		
		student.setStudentName("Kiran");
		student.setStudentStandard(12);
		FirstTerm one=new FirstTerm();
		SecondTerm two = new SecondTerm();
		FinalTerm finalTerm = new FinalTerm();
		
		student.setFinalTerm(finalTerm);
		student.setSecondTerm(two);
		student.setFirstTerm(one);
		
		student.getFinalTerm().setMarathiMarks(55);
		student.getSecondTerm().setMarathiMarks(70);
		student.getFinalTerm().setMarathiMarks(75);
		student.getFirstTerm().setHindiMarks(70);
		student.getSecondTerm().setHindiMarks(60);
		student.getFinalTerm().setHindiMarks(55);
		student.getFirstTerm().setEnglishMarks(60);
		student.getSecondTerm().setEnglishMarks(55);
		student.getFinalTerm().setEnglishMarks(52);
		
		repository.save(student);
		
		//When
		final ValidatableResponse response = RestAssured.given(requestSpecification).basePath("delstd/{id}")
				.pathParam("id", student.getStudentId()).when().delete().then();
		
		//then
		assertEquals(HttpStatus.OK.value(), response.extract().statusCode());
	}
}