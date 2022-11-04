package com.kiran.reportgenerator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="secondterm")
public class SecondTerm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private Integer hindiMarks;
	
	@Column
	private Integer englishMarks;
	
	@Column
	private Integer marathiMarks;
	
	
	public Integer getHindiMarks() {
		return hindiMarks;
	}
	public Integer getEnglishMarks() {
		return englishMarks;
	}
	
	public void setHindiMarks(Integer hindiMarks) {
		this.hindiMarks = hindiMarks;
	}
	public void setEnglishMarks(Integer englishMarks) {
		this.englishMarks = englishMarks;
	}
	public Integer getMarathiMarks() {
		return marathiMarks;
	}
	public void setMarathiMarks(Integer marathiMarks) {
		this.marathiMarks = marathiMarks;
	}
	
}
