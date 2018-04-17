package tableItems;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Grade{
	
	private String course;
	private int grade;
	
	@JsonCreator
	public Grade(@JsonProperty("course") String course, @JsonProperty("grade") int grade) {
		this.course = course;
		this.grade = grade;
	}
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String toString() {
		return this.course + " " + this.grade;
	}
}
