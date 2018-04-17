package dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dao.entities.Group;

public interface GroupRepository extends JpaRepository<Group, Integer>{
	
	public Group findByNumber(String number);
	
	public List<Group> findAllByOrderByNumber();
}
