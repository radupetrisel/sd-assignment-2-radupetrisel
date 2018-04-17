package bll.dtos;

import java.util.List;
import java.util.stream.Collectors;

import dao.entities.Teacher;

public class TeacherDto extends UserDto{

	private List<CourseDto> courses;
	
	public TeacherDto() {
		
	}
	
	public TeacherDto(Teacher t) {
		super(t);
		this.courses = t.getCourses().stream().map(c -> new CourseDto(c)).collect(Collectors.toList());
	}

	public List<CourseDto> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseDto> courses) {
		this.courses = courses;
	}	

}
