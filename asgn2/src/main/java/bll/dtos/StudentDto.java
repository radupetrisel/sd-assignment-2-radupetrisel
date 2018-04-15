package bll.dtos;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dao.entities.Course;
import dao.entities.Student;

public class StudentDto extends UserDto {
	
	private List<CourseDto> courses;
	
	public StudentDto() {
		
	}
	
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

	@Override
	public String toString() {
		return "StudentDto [courses=" + courses + ", id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", cnp=" + cnp
				+ ", password=" + password + "]";
	}

}
