package com.cqsr.query.event;

import com.cqsr.query.model.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEvent {

	private String type;
	private Student student;
}
