package dao.entities;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "students")
public class Student extends User {
	
	@Transient
	private List<Enrol> enrols;

	public List<Course> getCourses() {
		return enrols.stream().map(e -> e.getCourse()).collect(Collectors.toList());
	}

	public void setCourses(List<Enrol> enrols) {
		this.enrols = enrols;
	}
	
	public void addCourse(Course c) {
		this.enrols.add(new Enrol(this, c));
	}
	

}
