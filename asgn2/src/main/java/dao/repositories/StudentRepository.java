package dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dao.entities.Group;
import dao.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{	
	
	public List<Student> findByGroup(Group g);
	
	public Student findByCnp(String cnp);
}
