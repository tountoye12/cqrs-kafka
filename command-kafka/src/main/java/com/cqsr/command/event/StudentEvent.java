package com.cqsr.command.event;


import com.cqsr.command.model.Student;
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
