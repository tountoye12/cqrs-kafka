package com.cqsr.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cqsr.model.Student;
import com.cqsr.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping
	public ResponseEntity<Student> createNewData(@RequestBody Student student){

		return ResponseEntity.ok(studentService.createStudent(student));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> editStudent(@PathVariable(name = "id") Long id, @RequestBody Student student){
		
		return ResponseEntity.ok(studentService.updateStudent(id, student));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable(name = "id") Long id){
		
		return ResponseEntity.ok(studentService.deleteStudent(id));
	}
}
