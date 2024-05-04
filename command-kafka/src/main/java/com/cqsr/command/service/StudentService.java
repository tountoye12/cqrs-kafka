package com.cqsr.command.service;

import com.cqsr.command.event.StudentEvent;
import com.cqsr.command.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cqsr.command.model.Student;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	@Value("${spring.kafka.template.default-topic}")
	private String topic;
	private StudentRepository studentRepository;
	private KafkaTemplate<String, StudentEvent> kafkaTemplate;
	public StudentService(StudentRepository studentRepository, KafkaTemplate<String, StudentEvent> kafkaTemplate) {
		this.studentRepository = studentRepository;
		this.kafkaTemplate = kafkaTemplate;
	}
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		var retStudent = studentRepository.save(student);
		var studentEvent = new StudentEvent("createStudent", retStudent);
		kafkaTemplate.send(topic, studentEvent);
		return  retStudent;
	}

	public Student updateStudent(Long id ,Student request) {
		// TODO Auto-generated method stub

		var student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

		student.setLastname(request.getLastname());
		student.setFirstname(request.getFirstname());
		studentRepository.save(student);
		var studentEvent = new StudentEvent("updateStudent", student);
		kafkaTemplate.send(topic, studentEvent);
		return student;
	}
	
	public Student deleteStudent(Long id) {
		// TODO Auto-generated method stub

		var student = studentRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Not found")
		);
		studentRepository.deleteById(id);
		var studentEvent = new StudentEvent("deleteStudent", student);
		kafkaTemplate.send(topic, studentEvent);
		return student;
	}

}
