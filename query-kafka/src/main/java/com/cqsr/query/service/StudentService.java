package com.cqsr.query.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cqsr.query.model.Student;
import com.cqsr.query.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;
	
	public Student getStudentById(long id) {
		Optional<Student> student = studentRepository.findById(id);
		return student.get();
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
}
