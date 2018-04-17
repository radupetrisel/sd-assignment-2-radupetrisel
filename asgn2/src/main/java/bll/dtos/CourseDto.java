package bll.dtos;

import dao.entities.Course;
import dao.entities.Teacher;

public class CourseDto {

	private String name;
	private TeacherDto teacher;

	public CourseDto(Course c) {
		
		this.name = c.getName();
		this.teacher = new TeacherDto(c.getTeacher());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TeacherDto getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherDto teacher) {
		this.teacher = teacher;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
