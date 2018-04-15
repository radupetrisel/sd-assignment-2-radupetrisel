package bll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bll.dtos.CourseDto;
import bll.dtos.StudentDto;
import dao.entities.Course;
import dao.entities.Student;
import dao.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	//@Autowired
	//private EnrolRepository enrolRepo;
	
	public StudentDto getProfile(int id) throws NoSuchElementException {
		
		return new StudentDto(repo.findById(id).get());
	}
	
	public void updateAddress(int id, String address) {
		
		Student s = repo.getOne(id);
		s.setAddress(address);
		repo.save(s);
	}

	public Map<CourseDto, Integer> viewGrades(int id) {
		
		Map<CourseDto, Integer> map = new HashMap<CourseDto, Integer>();
		
		List<Course> courses = repo.findById(id).get().getCourses();
		
		courses.forEach(c -> {
			
			Integer grade = 0; //enrolRepo.findByStudentAndCourse(id, c.getId()).getGrade();
			
			map.put(new CourseDto(c), grade);
		});
		
		return map;
	}
	
	public void enrol() {
		
	}
	
	
}
