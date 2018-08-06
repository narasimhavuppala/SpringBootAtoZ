package com.example.Springbootcrud.controller;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.Springbootcrud.model.Student;
import com.example.Springbootcrud.service.StudentService;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping
	public Student createStudent(@RequestBody Student obj) {
		return service.createStudent(obj);
	}
	
	@GetMapping
	public Student getStudent(Integer studnetId) {
		return service.getStudent(5);
	}
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<String> getExceptions(Throwable t) {
		System.out.println(t.getMessage());
		System.out.println("Error Occureded");
		return new ResponseEntity<String>("Error occured",HttpStatus.INTERNAL_SERVER_ERROR) ;
		
	}

}
