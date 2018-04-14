package bll.dtos;

import java.util.List;

import dao.entities.Course;
import dao.entities.Student;
import dao.entities.Teacher;

public class CourseDto {

	private int id;
	private String name;
	private Teacher teacher;
	private List<Student> students;
	
	public CourseDto(Course c) {
		
		this.id = c.getId();
		this.name = c.getName();
		this.teacher = c.getTeacher();
		this.students = c.getStudents();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
