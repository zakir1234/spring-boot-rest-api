package com.spring.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.common.enums.MessageContainer;
import com.spring.dto.StudentDTO;
import com.spring.dto.TeacherDTO;
import com.spring.entity.Teacher;
import com.spring.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;

	@PostMapping("/save")
	public ResponseEntity<?> saveStudent(@RequestBody TeacherDTO teacherDTO) {			
		return new ResponseEntity<>(teacherService.saveTeacher(teacherDTO), HttpStatus.CREATED);
	}
}
