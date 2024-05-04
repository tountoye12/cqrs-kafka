package com.cqsr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cqsr.event.StudentEvent;
import com.cqsr.model.Student;
import com.cqsr.repository.StudentRepository;

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
	
	@KafkaListener(topics = "student-topic", groupId = "student-group1")
	public void processStudentEvents(StudentEvent studentEvent) {
		Student student = studentEvent.getStudent();
		
		if(studentEvent.getType().equals("createStudent")) {
			studentRepository.save(student);
		}
		else if(studentEvent.getType().equals("updateStudent")) {
			Student existStudent = studentRepository.findById(student.getId()).get();
			existStudent.setFirstname(student.getFirstname());
			existStudent.setLastname(student.getLastname());
			existStudent.setCourse(student.getCourse());
			existStudent.setGrade(student.getGrade());
			studentRepository.save(existStudent);
		}
		else if(studentEvent.getType().equals("deleteStudent")) {
			studentRepository.delete(student);
		}
	}
}
