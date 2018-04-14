package dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dao.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
