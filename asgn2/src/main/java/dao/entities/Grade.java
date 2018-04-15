package dao.entities;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "grades")
@AssociationOverrides({
	@AssociationOverride(name = "id.student", joinColumns = @JoinColumn(name = "student_id")),
	@AssociationOverride(name = "id.course", joinColumns = @JoinColumn(name = "course_id"))
})
public class Grade {
	
	@EmbeddedId
	private Enrol id = new Enrol(); 
	
	public Enrol getId() {
		return id;
	}

	public void setId(Enrol id) {
		this.id = id;
	}
	
	@Column
	private int grade;
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Transient
	public Student getStudent() {
		return this.id.getStudent();
	}
	
	public void setStudent(Student s) {
		this.id.setStudent(s);
	}
	
	@Transient
	public Course getCourse() {
		return this.id.getCourse();
	}
	
	public void setCourse(Course c) {
		this.id.setCourse(c);
	}

}
