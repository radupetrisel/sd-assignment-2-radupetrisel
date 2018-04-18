package bll.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dao.entities.StudentReport;

public class StudentReportDto {

	private StudentDto student;
	
	private String date;
	
	public StudentReportDto() {
		
	}
	
	@JsonCreator
	public StudentReportDto(@JsonProperty("student") StudentDto student, @JsonProperty("date") String date) {

		this.student = student;
		this.date = date;
	}
	
	public StudentReportDto(StudentReport report) {
		this.student = new StudentDto(report.getStudent());
		this.date = report.getDate();
	}

	public StudentDto getStudent() {
		return student;
	}

	public void setStudent(StudentDto student) {
		this.student = student;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
