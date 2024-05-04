package com.cqsr.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cqsr.event.StudentEvent;
import com.cqsr.model.Student;
import com.cqsr.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
		log.info("Student -> " + student);
		
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
