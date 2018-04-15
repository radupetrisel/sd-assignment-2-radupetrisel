package dao.entities;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "courses")
public class Course {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
	
	@Transient
	private List<Enrol> students;
	
	public List<Student> getStudents() {
		return students.stream().map(s -> s.getStudent()).collect(Collectors.toList());
	}

	public void setStudents(List<Enrol> students) {
		this.students = students;
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
	
}