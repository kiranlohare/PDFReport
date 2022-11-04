package com.kiran.reportgenerator.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId_PK")
	private Integer studentId;
	@Column
	private String studentName;
	@Column
	private Integer studentStandard;

	@OneToOne(cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="studentId_FT")
	private FirstTerm firstTerm;
	
	@OneToOne(cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="studentId_ST")
	private SecondTerm secondTerm;
	
	@OneToOne(cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="studentId_Final")
	private FinalTerm finalTerm;

	public FirstTerm getFirstTerm() {
		return firstTerm;
	}

	public SecondTerm getSecondTerm() {
		return secondTerm;
	}

	public FinalTerm getFinalTerm() {
		return finalTerm;
	}

	public void setFirstTerm(FirstTerm firstTerm) {
		this.firstTerm = firstTerm;
	}

	public void setSecondTerm(SecondTerm secondTerm) {
		this.secondTerm = secondTerm;
	}

	public void setFinalTerm(FinalTerm finalTerm) {
		this.finalTerm = finalTerm;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public Integer getStudentStandard() {
		return studentStandard;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setStudentStandard(Integer studentStandard) {
		this.studentStandard = studentStandard;
	}
}
