package com.kiran.reportgenerator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="finalterm")
public class FinalTerm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private Integer hindiMarks;
	
	@Column
	private Integer englishMarks;
	
	@Column
	private Integer mathsMarks;
	
	
	public Integer getHindiMarks() {
		return hindiMarks;
	}
	public Integer getEnglishMarks() {
		return englishMarks;
	}
	public Integer getMathsMarks() {
		return mathsMarks;
	}
	public void setHindiMarks(Integer hindiMarks) {
		this.hindiMarks = hindiMarks;
	}
	public void setEnglishMarks(Integer englishMarks) {
		this.englishMarks = englishMarks;
	}
	public void setMathsMarks(Integer mathsMarks) {
		this.mathsMarks = mathsMarks;
	}
}
