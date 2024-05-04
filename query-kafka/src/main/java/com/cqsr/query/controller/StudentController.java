package com.cqsr.query.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cqsr.query.model.Student;
import com.cqsr.query.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

	private final StudentService studentService;
	
	@GetMapping
	public ResponseEntity<?> getStudent(long id){
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<>(student, HttpStatus.FOUND);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllStudent(){
		List<Student> students = studentService.getAllStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
}
