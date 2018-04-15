package pl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bll.TeacherService;
import bll.dtos.TeacherDto;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService service;
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public @ResponseBody TeacherDto viewProfile(@RequestParam("id") int id) {
		
		TeacherDto t = service.getProfile(id);
	
		return t;
	}

	public String updateAddress(int id, String address) {
		return null;
	}
	
}
