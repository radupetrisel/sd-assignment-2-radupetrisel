package bll;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bll.dtos.GradeDto;
import bll.dtos.StudentDto;
import bll.exceptions.CourseNotFoundException;
import dao.entities.Course;
import dao.entities.Student;
import dao.repositories.CourseRepository;
import dao.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private CourseRepository courseRepo;

	public void save(Student student) {
		studentRepo.save(student);
	}

	public StudentDto getProfile(int studentId) throws NoSuchElementException {

		return new StudentDto(studentRepo.findById(studentId).get());
	}

	public void updateAddress(int studentId, String address) {

		Student s = studentRepo.getOne(studentId);
		s.setAddress(address);
		studentRepo.save(s);
	}

	public List<GradeDto> viewGrades(int studentId) {

		List<GradeDto> grades = studentRepo.findById(studentId).get().getGrades().stream().map(g -> new GradeDto(g))
				.collect(Collectors.toList());

		return grades;
	}

	public void enrol(int studentId, String courseName) throws CourseNotFoundException {

		try {

			Student s = studentRepo.getOne(studentId);

			Course c = courseRepo.findByName(courseName).get(0);

			s.addCourse(c);

			studentRepo.save(s);
		} catch (IndexOutOfBoundsException e) {
			throw new CourseNotFoundException("Course" + courseName + " not found!\n");
		}
	}

}
