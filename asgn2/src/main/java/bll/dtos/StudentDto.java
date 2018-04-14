package bll.dtos;

import java.util.List;
import java.util.stream.Collectors;

import dao.entities.Student;

public class StudentDto extends UserDto {
	
	private List<CourseDto> courses;
	
	public StudentDto(Student s) {
		super(s);
		this.courses = s.getCourses().stream().map(c -> new CourseDto(c)).collect(Collectors.toList());
	}

	public List<CourseDto> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseDto> courses) {
		this.courses = courses;
	}
	
	public void addCourse(CourseDto c) {
		
	}

}
