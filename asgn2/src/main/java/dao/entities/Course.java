package dao.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "courses")
public class Course{
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@OneToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Grade> grades = new ArrayList<Grade>();
	
	@Transient
	public List<Student> getStudents(){
		return grades.stream().map(g -> g.getStudent()).collect(Collectors.toList());
	}
	
	public List<Grade> getGrades() {
		return grades;
	}

	public void setStudents(List<Grade> grades) {
		this.grades = grades;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.name + " " + this.teacher;
	}
}