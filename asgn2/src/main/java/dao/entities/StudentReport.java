package dao.entities;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class StudentReport {
	
	@Id
	@GeneratedValue
	private int id;
	
	private Student student;
	private String date;

	@Override
	public String toString() {
		return "StudentReport [id=" + id + ", student=" + student + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
