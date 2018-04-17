package services;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import tableItems.Student;

public class StudentReport {

	private Student student;
	private LocalDateTime date;
	
	@JsonCreator
	public StudentReport(@JsonProperty("student") Student student, @JsonProperty("date") LocalDateTime date) {
		this.student = student;
		this.date = date;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
