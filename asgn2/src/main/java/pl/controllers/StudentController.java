package pl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bll.StudentService;
import bll.dtos.GradeDto;
import bll.dtos.StudentDto;
import bll.exceptions.CourseNotFoundException;
import dao.entities.Student;

@Controller
@RequestMapping("/student/{id}")
public class StudentController {
	
	@Autowired
	private StudentService service;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody StudentDto save(@RequestBody Student student) {

		service.save(student);

		return new StudentDto(student);
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public @ResponseBody StudentDto viewProfile(@PathVariable("id") int id) {

		StudentDto s = service.getProfile(id);

		return s;
	}

	@RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
	public @ResponseBody String updateAddress(@PathVariable int id, @RequestBody StudentDto student) {

		service.updateAddress(id, student.getAddress());
		return "success";
	}

	@RequestMapping(value = "/viewGrades", method = RequestMethod.GET)
	public @ResponseBody List<GradeDto> viewGrades(@PathVariable("id") int id) {

		List<GradeDto> grades = service.viewGrades(id);
		
		return grades;
	}
	
	@RequestMapping(value = "/enrol", method = RequestMethod.POST)
	public @ResponseBody String enrol(@PathVariable("id") int id, @RequestBody String courseName) {
		
		try {
			service.enrol(id, courseName);
		} catch (CourseNotFoundException e) {
			return e.getMessage();
		}
		
		return "success";
	}

}
