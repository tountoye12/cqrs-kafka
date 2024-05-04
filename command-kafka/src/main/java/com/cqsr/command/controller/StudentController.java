package com.cqsr.command.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cqsr.command.model.Student;
import com.cqsr.command.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

	private final StudentService studentService;
	
	@PostMapping
	public ResponseEntity<?> createNewData(@RequestBody Student student){
		
		
		return null;
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> editStudent(@PathVariable(name = "id") long id, @RequestBody Student student){
		
		return null;
	}
	
	@DeleteMapping("{id")
	public ResponseEntity<Long> deleteStudent(@PathVariable(name = "id") long id){
		
		return null;
	}
}
