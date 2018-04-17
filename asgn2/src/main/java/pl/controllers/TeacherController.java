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

import bll.TeacherService;
import bll.dtos.StudentDto;
import bll.dtos.TeacherDto;

@Controller
@RequestMapping(value = "/teacher/{id}")
public class TeacherController {
	
	@Autowired
	private TeacherService service;
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public @ResponseBody TeacherDto viewProfile(@PathVariable("id") int id) {
		
		TeacherDto t = service.getProfile(id);
	
		return t;
	}

	@RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
	public @ResponseBody String updateAddress(@PathVariable int id, @RequestBody TeacherDto teacher) {
		
		service.updateAddress(id, teacher.getAddress());
		
		return "Address updated successfully!\n";
	}
	
	@RequestMapping(value = "/createStudent", method = RequestMethod.POST)
	public @ResponseBody String createStudent(@RequestBody StudentDto student) {
		
		service.createStudent(student);
		
		return "Success";
	}
	
	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public @ResponseBody String updateStudentByCnp(@RequestBody StudentDto s) {
		
		service.updateStudentByCnp(s);
		
		return "Success";
	}
	
	@RequestMapping(value = "/viewStudents", method = RequestMethod.GET)
	public @ResponseBody List<StudentDto> viewStudents(@RequestParam("group") String group){
		
		return service.viewStudentsFromGroup(group);	
	}
	
}
