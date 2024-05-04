package com.cqsr.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cqsr.query.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
