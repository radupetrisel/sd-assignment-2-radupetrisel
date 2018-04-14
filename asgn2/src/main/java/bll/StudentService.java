package bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.entities.Student;
import dao.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public void save(Student s) {
		
		repo.save(s);
		
	}
	
	public List<Student> findAll(){
		
		return repo.findAll();
	}
	
	public Student findById(int id) {
		
		return (Student)repo.findById(id).get();
	}
	
	
}
