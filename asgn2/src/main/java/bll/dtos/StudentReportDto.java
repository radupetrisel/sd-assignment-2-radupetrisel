package bll.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import dao.entities.StudentReport;

public class StudentReportDto {

	private StudentDto student;
	private LocalDateTime date;
	
	public StudentReportDto() {
		
	}
	
	@JsonCreator
	public StudentReportDto(@JsonProperty("student") StudentDto student, @JsonProperty("date") LocalDateTime date) {
		ObjectMapper mapper = new ObjectMapper();
		 mapper.registerModule(new JavaTimeModule());
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
}
