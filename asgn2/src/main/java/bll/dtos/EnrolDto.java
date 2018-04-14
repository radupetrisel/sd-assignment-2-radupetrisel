package bll.dtos;

import dao.entities.Course;
import dao.entities.Enrol;
import dao.entities.Student;

public class EnrolDto {

	private int id;
	private int grade;
	private Student student;
	private Course course;
	
	public EnrolDto(Enrol e) {
		
		this.id = e.getId();
		this.grade = e.getGrade();
		this.student = e.getStudent();
		this.course = e.getCourse();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
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
