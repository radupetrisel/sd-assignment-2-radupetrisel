package dao.mongoRepositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import bll.dtos.StudentReportDto;

public interface StudentMongoRepository extends MongoRepository<StudentReportDto, Integer>{

}
