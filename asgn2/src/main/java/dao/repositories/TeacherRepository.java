package dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dao.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

}
