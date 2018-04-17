package bll.builders;

import dao.entities.Group;
import dao.entities.Student;

public class StudentBuilder{
	
	private Student student;
	
	public StudentBuilder() {
		this.student = new Student();
	}
	
	public StudentBuilder firstName(String firstName) {
		student.setFirstName(firstName);
		return this;
	}
	
	public StudentBuilder lastName(String lastName) {
		student.setLastName(lastName);
		return this;
	}
	
	public StudentBuilder cnp(String cnp) {
		student.setCnp(cnp);
		return this;
	}
	
	public StudentBuilder address(String address) {
		student.setAddress(address);
		return this;
	}
	
	public StudentBuilder phoneNumber(String phoneNumber) {
		student.setPhoneNumber(phoneNumber);
		return this;
	}
	
	public StudentBuilder email(String email) {
		student.setEmail(email);
		return this;
	}
	
	public StudentBuilder group(Group group) {
		student.setGroup(group);
		return this;
	}
	
	public Student build() {
		return this.student;
	}
	

}
