package bll.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dao.entities.Student;

public class StudentDto extends UserDto {

	private List<GradeDto> courses;

	private String group;

	public StudentDto() {

	}

	@JsonCreator
	public StudentDto(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName,
			@JsonProperty("address") String address, @JsonProperty("phoneNumber") String phoneNumber,
			@JsonProperty("cnp") String cnp, @JsonProperty("email") String email,
			@JsonProperty("password") String password, @JsonProperty("group") String group,
			@JsonProperty("courses") List<GradeDto> grades) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.cnp = cnp;
		this.email = email;
		this.password = password;
		this.group = group;
		this.courses = grades;
		
	}

	public StudentDto(Student s) {
		super(s);
		this.group = s.getGroup().getNumber();
		this.courses = s.getGrades().stream().map(g -> new GradeDto(g)).collect(Collectors.toList());
	}

	public List<GradeDto> getCourses() {
		return courses;
	}

	public void setCourses(List<GradeDto> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "StudentDto [courses=" + courses + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", cnp=" + cnp + ", password="
				+ password + "]";
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}
