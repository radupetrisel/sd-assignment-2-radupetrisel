package bll;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bll.builders.GroupBuilder;
import bll.builders.StudentBuilder;
import bll.dtos.GroupDto;
import bll.dtos.StudentDto;
import bll.dtos.TeacherDto;
import dao.entities.Group;
import dao.entities.Student;
import dao.entities.Teacher;
import dao.repositories.GroupRepository;
import dao.repositories.StudentRepository;
import dao.repositories.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private GroupRepository groupRepo;

	public TeacherDto getProfile(int id) {

		return new TeacherDto(teacherRepo.findById(id).get());
	}

	public void updateAddress(int id, String address) {

		Teacher teacher = teacherRepo.getOne(id);

		teacher.setAddress(address);

		teacherRepo.save(teacher);
	}
	
	public void createStudent(StudentDto student) {
		
		Group g = groupRepo.findByNumber(student.getGroup());
		
		Student s = new StudentBuilder()
				.firstName(student.getFirstName())
				.lastName(student.getLastName())
				.cnp(student.getCnp())
				.email(student.getEmail())
				.address(student.getAddress())
				.phoneNumber(student.getPhoneNumber())
				.group(g)
				.build();
		
		studentRepo.save(s);
	}
	
	public List<StudentDto> viewStudentsFromGroup(String group){
		
		Group g = groupRepo.findByNumber(group);
		
		return studentRepo.findByGroup(g).stream().map(s -> new StudentDto(s)).collect(Collectors.toList());
	}
	
	public void updateStudentByCnp(StudentDto studentToUpdate) {

		Student student = studentRepo.findByCnp(studentToUpdate.getCnp());
		student.setAddress(studentToUpdate.getAddress());
		student.setEmail(studentToUpdate.getEmail());
		student.setPhoneNumber(studentToUpdate.getPhoneNumber());

		studentRepo.save(student);
	}
}
