package com.spring.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.TeacherDTO;
import com.spring.entity.Student;
import com.spring.entity.Teacher;
import com.spring.repo.StudentRepo;
import com.spring.repo.TeacherRepository;

@Service
@Transactional
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private StudentRepo studentRepo;

	public Long saveTeacher(TeacherDTO teacherDTO) {
		
		Teacher teacher = new Teacher();
		teacher.setTeacherName("Test Teacher");
		
				
		  Student student1 = new Student();
		  student1.setStudentName("Student 1");
		  student1.setStudentRoll(1);
		  student1.setTeacher(teacher);
		  
		  Student student2 = new Student();
		  student2.setStudentName("Student 2");
		  student2.setStudentRoll(2);
		  student2.setTeacher(teacher);
		  
		  Student student3 = new Student();
		  student3.setStudentName("Student 3");
		  student3.setStudentRoll(3);
		  student3.setTeacher(teacher);
		  
		  teacher.getStudents().add(student1);
		  teacher.getStudents().add(student2);
		  teacher.getStudents().add(student3);
		
		
		Teacher t = teacherRepository.save(teacher);
		 
	//	 studentRepo.saveAll(students);
		
		return 0l;
				

	}
	
	

}
