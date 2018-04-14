package bll.dtos;

import java.util.List;

import dao.entities.Course;
import dao.entities.Teacher;

public class TeacherDto extends UserDto{

	private List<Course> courses;
	
	public TeacherDto(Teacher t) {
		super(t);
		this.setCourses(t.getCourses());
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}	

}
