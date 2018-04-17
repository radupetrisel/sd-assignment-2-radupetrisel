package dao.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "students")
public class Student extends User{
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Grade> grades = new ArrayList<Grade>();
	
	@OneToOne
	@JoinColumn(name = "group_no")
	private Group group;
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Transient
	public List<Course> getCourses() {
		return grades.stream().map(g -> g.getCourse()).collect(Collectors.toList());
	}

	public void setGrades(List<Grade> grades) {
		this.grades.clear();
		
		this.grades.addAll(grades);
	}
	
	public void setCourses(List<Course> courses) {
		courses.forEach(c -> this.addCourse(c));
	}
	@Transient
	public void addCourse(Course c) {
		
		this.grades.add(new Grade(this, c));
	}

	public List<Grade> getGrades() {
		return grades;
	}
	
	@Override
	public String toString() {
		return super.toString() + " courses: " + this.getCourses();
	}
}
