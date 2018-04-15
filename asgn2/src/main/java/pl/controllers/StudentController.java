package pl.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bll.StudentService;
import bll.dtos.CourseDto;
import bll.dtos.StudentDto;


@Controller
@RequestMapping("/student")
public class StudentController{

	@Autowired
	private StudentService service;
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public @ResponseBody StudentDto viewProfile(@RequestParam("id") int id) {
		
		StudentDto s = service.getProfile(id);

		return s;
	}
	
	@RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
	public @ResponseBody String updateAddress(@RequestBody StudentDto student) {
		
		service.updateAddress(student.getId(), student.getAddress());
		return "success";
	}
	
	@RequestMapping(value = "/viewGrades", method = RequestMethod.GET)
	public @ResponseBody Map<CourseDto, Integer> viewGrades(@RequestParam("id") int id) {
		
		Map<CourseDto, Integer> map = service.viewGrades(id);
		
		System.out.println(map);
		
		return null;
	}
	
	public void enrol() {
		
	}
	
}
