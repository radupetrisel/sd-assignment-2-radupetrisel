package bll.dtos;

import java.util.List;
import java.util.stream.Collectors;

import dao.entities.Group;

public class GroupDto {
	
	private String groupNo;
	private List<StudentDto> students;
	
	public GroupDto(Group group) {
		this.groupNo = group.getNumber();
		this.students = group.getStudents().stream().map(s -> new StudentDto(s)).collect(Collectors.toList());
	}
	
	public String getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	public List<StudentDto> getStudents() {
		return students;
	}
	public void setStudents(List<StudentDto> students) {
		this.students = students;
	}
	
	
}
