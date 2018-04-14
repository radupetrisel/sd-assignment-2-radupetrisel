package asgn.asgn2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("dao.entities")
@EnableJpaRepositories("dao.repositories")
@ComponentScan({"bll", "dao.entities", "dao.repositories", "pl.controllers"})
public class Asgn2Application {

	public static void main(String[] args) {
		SpringApplication.run(Asgn2Application.class, args);
	}
}
