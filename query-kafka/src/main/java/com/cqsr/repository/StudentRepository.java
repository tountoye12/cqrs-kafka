package com.cqsr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cqsr.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
