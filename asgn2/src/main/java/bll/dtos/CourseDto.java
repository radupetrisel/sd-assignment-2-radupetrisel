package bll.dtos;

import dao.entities.Course;
import dao.entities.Teacher;

public class CourseDto {

	private String name;
	private String teacher;

	public CourseDto(Course c) {
		
		this.name = c.getName();
		this.teacher = c.getTeacher().getFirstName() + " " + c.getTeacher().getLastName();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher.getFirstName() + " " + teacher.getLastName();
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
