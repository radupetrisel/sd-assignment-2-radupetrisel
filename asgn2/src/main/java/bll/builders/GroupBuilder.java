package bll.builders;

import java.util.List;

import dao.entities.Group;
import dao.entities.Student;

public class GroupBuilder {
	
	private Group group;
	
	public GroupBuilder() {
		this.group = new Group();		
	}
	
	public GroupBuilder number(String number) {
		group.setNumber(number);
		return this;
	}
	
	public GroupBuilder students(List<Student> students) {
		group.setStudents(students);
		return this;
	}
	
	public Group build() {
		return group;
	}

}
