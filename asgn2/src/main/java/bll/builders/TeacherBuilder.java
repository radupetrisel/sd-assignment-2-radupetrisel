package bll.builders;

import java.util.List;

import dao.entities.Course;
import dao.entities.Teacher;

public class TeacherBuilder {
	
	private Teacher teacher;
	
	public TeacherBuilder() {
		this.teacher = new Teacher();
	}
	
	public TeacherBuilder firstName(String firstName) {
		teacher.setFirstName(firstName);
		return this;
	}
	
	public TeacherBuilder lastName(String lastName) {
		teacher.setLastName(lastName);
		return this;
	}
	
	public TeacherBuilder cnp(String cnp) {
		teacher.setCnp(cnp);
		return this;
	}
	
	public TeacherBuilder address(String address) {
		teacher.setAddress(address);
		return this;
	}
	
	public TeacherBuilder phoneNumber(String phoneNumber) {
		teacher.setPhoneNumber(phoneNumber);
		return this;
	}
	
	public TeacherBuilder email(String email) {
		teacher.setEmail(email);
		return this;
	}
	
	public TeacherBuilder courses(List<Course> courses) {
		teacher.setCourses(courses);
		return this;
	}
	
	public Teacher build() {
		return this.teacher;
	}
}
