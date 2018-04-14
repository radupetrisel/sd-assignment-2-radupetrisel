package dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dao.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
