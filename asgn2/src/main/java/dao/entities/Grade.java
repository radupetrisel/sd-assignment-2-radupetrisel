package dao.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "grades")
public class Grade{
	
	@EmbeddedId
	private Enrol id = new Enrol(); 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("student")
	@JsonIgnore
	private Student student;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("course")
	private Course course;
	
	@Column
	private int grade = 0;
	
	public Grade() {}
	
	public Grade(Student student, Course course) {
		this.student = student;
		this.course = course;
		id.setStudentId(student.getId());
		id.setCourseId(course.getId());
	}
	
	public Enrol getId() {
		return id;
	}

	public void setId(Enrol id) {
		this.id = id;
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return this.student;
	}
	
	public void setStudent(Student s) {
		this.student = s;
		this.id.setStudentId(s.getId());
	}
	
	public Course getCourse() {
		return this.course;
	}
	
	public void setCourse(Course c) {
		this.course = c;
		this.id.setCourseId(c.getId());
	}

}
