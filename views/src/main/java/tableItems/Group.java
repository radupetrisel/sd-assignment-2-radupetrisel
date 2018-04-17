package tableItems;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Group {

	private String number;
	private List<Student> students;

	@JsonCreator
	public Group(@JsonProperty("number") String number, @JsonProperty("students") List<Student> students) {
		this.number = number;
		this.students = students;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
