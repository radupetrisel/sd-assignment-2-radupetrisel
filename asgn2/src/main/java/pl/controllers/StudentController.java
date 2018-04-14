package pl.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bll.StudentService;
import dao.entities.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@RequestMapping(value = "/save", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Student save(@RequestBody String json) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		Student s = null;
		
		try {
			System.out.println(json);
			s = mapper.readValue(json, Student.class);
		} catch (IOException e) {
			e.printStackTrace();
		} 

		service.save(s);

		return s;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	@ResponseBody
	public String list() {
		
		Student s = service.findById(1);
		String studentJSON = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			studentJSON = mapper.writeValueAsString(s);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return studentJSON;
	}

}
