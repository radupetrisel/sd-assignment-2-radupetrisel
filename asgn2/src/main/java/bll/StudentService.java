package bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bll.dtos.StudentDto;
import dao.entities.Student;
import dao.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public StudentDto profile(int id) {
		
		return new StudentDto(repo.findById(id));
	}
	
	public void updatePassword() {
		
		
		
	}
	
	public void updateAddress() {
		
	}

	public String viewGrades() {
		return null;
	}
	
	public void enrol() {
		
	}
	
	
}
