package bll.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dao.entities.Group;

public class GroupDto {

	private String number;
	private List<StudentDto> students;

	public GroupDto() {

	}

	@JsonCreator
	public GroupDto(@JsonProperty("number") String number, @JsonProperty("students") List<StudentDto> students) {
		this.number = number;
		this.students = students;
	}

	public GroupDto(Group group) {
		this.number = group.getNumber();
		this.students = group.getStudents().stream().map(s -> new StudentDto(s)).collect(Collectors.toList());
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<StudentDto> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDto> students) {
		this.students = students;
	}

}
