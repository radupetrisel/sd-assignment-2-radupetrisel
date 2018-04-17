package dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dao.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	public List<Course> findByName(String firstName);
}
