package dao.mongoRepositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import dao.entities.StudentReport;

public interface StudentMongoRepository extends MongoRepository<StudentReport, Integer>{

}
