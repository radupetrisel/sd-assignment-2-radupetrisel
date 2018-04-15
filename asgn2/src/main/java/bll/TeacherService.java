package bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bll.dtos.TeacherDto;
import dao.repositories.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository repo;
	
	public TeacherDto getProfile(int id) {
		
		return new TeacherDto(repo.findById(id).get());
	}

}
