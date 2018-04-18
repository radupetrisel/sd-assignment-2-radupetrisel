package tableItems;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class StudentReport {

	private Student student;
	
	private String date;
	
	@JsonCreator
	public StudentReport(@JsonProperty("student") Student student, @JsonProperty("date") LocalDateTime date) {
		this.student = student;
		this.date = date.toString();
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
