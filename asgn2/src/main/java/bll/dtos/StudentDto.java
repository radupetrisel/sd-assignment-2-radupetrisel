package bll.dtos;

import java.util.List;

import dao.entities.Student;

public class StudentDto extends UserDto {
	
	private List<GradeDto> courses;
	
	private String group;
	
	public StudentDto() {
		
	}
	
	public StudentDto(Student s) {
		super(s);
		this.group = s.getGroup().getNumber();
	}

	public List<GradeDto> getCourses() {
		return courses;
	}

	public void setCourses(List<GradeDto> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "StudentDto [courses=" + courses + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", cnp=" + cnp
				+ ", password=" + password + "]";
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}
