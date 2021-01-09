package com.spring.dto;

import java.util.Set;
import com.spring.entity.Student;

import lombok.Data;

@Data
public class TeacherDTO {

	private Long teacherId;
	private String teacherName;
	private Set<Student> students;

}
