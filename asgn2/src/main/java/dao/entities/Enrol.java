package dao.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Enrol implements Serializable {

	@Column(name = "student_id")
	private int studentId;

	@Column(name = "course_id")
	private int courseId;

	public Enrol() {

	}
	
	public Enrol(int studentId, int courseId) {
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Override
	public boolean equals(Object o) {
		
		if (this == o) return true;
		if (!(o instanceof Enrol)) return false;
		
		Enrol other = (Enrol)o;
		
		return other.getCourseId() == this.courseId && other.getStudentId() == this.studentId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentId, courseId);
	}
	
	public String toString() {
		return this.studentId + " " + this.courseId;
	}

}
