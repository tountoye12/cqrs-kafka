package com.cqsr.command.service;

import com.cqsr.command.repository.StudentRepository;
import org.springframework.stereotype.Service;

import com.cqsr.command.model.Student;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
	
	private StudentRepository studentRepository;
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	public Student updateStudent(Long id ,Student request) {
		// TODO Auto-generated method stub

		var student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

		student.setLastname(request.getLastname());
		student.setFirstname(request.getFirstname());
		student.setCourse(request.getCourse());
		student.setGrade(request.getGrade());
		return student;
	}
	
	public Student deleteStudent(Long id) {
		// TODO Auto-generated method stub

		var student = studentRepository.findById(id);
		studentRepository.deleteById(id);
		return student.orElseThrow(
				() -> new RuntimeException("Not found")
		);
	}

}
