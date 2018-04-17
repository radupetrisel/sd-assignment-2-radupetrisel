package bll.dtos;

import java.util.List;
import java.util.stream.Collectors;

import dao.entities.Teacher;

public class TeacherDto extends UserDto{

	private List<String> courses;
	
	public TeacherDto() {
		
	}
	
	public TeacherDto(Teacher t) {
		super(t);
		this.courses = t.getCourses().stream().map(c -> c.getName()).collect(Collectors.toList());
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}	

}
