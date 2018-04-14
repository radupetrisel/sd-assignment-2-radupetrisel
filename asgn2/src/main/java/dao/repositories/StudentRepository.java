package dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dao.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
