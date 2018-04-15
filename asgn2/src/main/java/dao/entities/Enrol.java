package dao.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Enrol implements Serializable{
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Course course;

	public Enrol() {
		
	}
	
	public Enrol(Student student, Course course) {
		this.student = student;
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
