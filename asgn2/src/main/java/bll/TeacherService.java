package bll;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bll.builders.StudentBuilder;
import bll.dtos.GroupDto;
import bll.dtos.StudentDto;
import bll.dtos.StudentReportDto;
import bll.dtos.TeacherDto;
import dao.entities.Grade;
import dao.entities.Group;
import dao.entities.Student;
import dao.entities.StudentReport;
import dao.entities.Teacher;
import dao.mongoRepositories.StudentMongoRepository;
import dao.repositories.CourseRepository;
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

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private StudentMongoRepository studentMongoRepo;

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

		Student s = new StudentBuilder().firstName(student.getFirstName()).lastName(student.getLastName())
				.cnp(student.getCnp()).email(student.getEmail()).address(student.getAddress())
				.phoneNumber(student.getPhoneNumber()).group(g).build();

		studentRepo.save(s);
	}

	public List<StudentDto> viewStudentsFromGroup(String group) {

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

	public List<GroupDto> viewGroups() {

		return groupRepo.findAllByOrderByNumber().stream().map(g -> new GroupDto(g)).collect(Collectors.toList());
	}

	public void gradeStudent(StudentDto updated) {

		Student student = studentRepo.getOne(studentRepo.findByCnp(updated.getCnp()).getId());

		student.setGrades(updated.getCourses().stream().map(g -> {

			Grade grade = new Grade();
			grade.setStudent(student);

			grade.setCourse(courseRepo.findByName(g.getCourse()));
			grade.setGrade(g.getGrade());

			return grade;
		}).collect(Collectors.toList()));

		studentRepo.save(student);

	}

	public void saveReport(StudentReportDto studentReport) {

		StudentReport sr = new StudentReport();
		
		Student s = studentRepo.findByCnp(studentReport.getStudent().getCnp());
		
		sr.setStudent(s);
		sr.setDate(studentReport.getDate());

		studentMongoRepo.save(studentReport);
	}
}
