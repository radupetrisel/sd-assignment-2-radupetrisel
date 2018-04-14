package pl.controllers;

import static bll.JsonConverter.convertJSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bll.StudentService;
import bll.dtos.StudentDto;


@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	@ResponseBody
	public String profile(@RequestParam("id") int id) {
		
		StudentDto s = service.profile(id);
		
		String str = convertJSON(s);
		System.out.println(str);
		return str;
	}
	
	public void updatePassword() {
		
	}
	
	public void updateAddress() {
		
	}

	public String viewGrades() {
		return null;
	}
	
	public void enrol() {
		
	}
	
}
