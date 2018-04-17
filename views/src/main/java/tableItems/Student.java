package tableItems;

import java.util.List;

public class Student {

	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	private String cnp;
	private String password;
	private String group;
	private List<Grade> courses;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {

		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Grade> getCourses() {
		return courses;
	}

	public void setCourses(List<Grade> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " " + address + " " + phoneNumber + " " + email + " =" + cnp + " "
				+ password + ", courses: " + courses;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}
