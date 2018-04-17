package bll.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dao.entities.Grade;

public class GradeDto {

	private String course;
	private int grade;
	
	public GradeDto() {
		
	}
	
	@JsonCreator
	public GradeDto(@JsonProperty("course") String course, @JsonProperty("grade") int grade) {
		this.course = course;
		this.grade = grade;
	}
	
	public GradeDto(Grade grade) {
		this.course = grade.getCourse().getName();
		this.grade = grade.getGrade();
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return this.course + " " + this.grade;
	}
}
