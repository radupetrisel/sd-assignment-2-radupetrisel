package tableItems;

import java.util.Observable;

public class Grade extends Observable{
	
	private String course;
	private String grade;
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
