
package com.spring.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.spring.dto.StudentDTO;
import com.spring.entity.Student;
import com.spring.repo.StudentRepo;
import com.spring.common.enums.ErrorMessageContainer;
import com.spring.common.exception.customhandler.BadRequestExceptionHandler;
import com.spring.common.exception.customhandler.ResourceNotFoundExceptionHandler;

/**
 * 
 * @author Zakir
 *
 */

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	public void saveOrUpdateStudent(StudentDTO studentDTO) {
		
		Optional.ofNullable(studentDTO).orElseThrow(() -> new BadRequestExceptionHandler(String.format(ErrorMessageContainer.MESSAGE_TYPE_BAD_REQUEST.getMessageDetails(), "studentDTO")));

		Student student = copyStudentFromDtoOpt(Optional.ofNullable(studentDTO)).get();

		studentRepo.save(student);

	}

	
	public List<StudentDTO> findAllStudents() {

		List<Student> studentList = studentRepo.findAll();

		if (studentList.isEmpty()) {
			throw new ResourceNotFoundExceptionHandler(ErrorMessageContainer.MESSAGE_TYPE_RESOURCE_NOT_FOUND.getMessageDetails());
		}

		List<StudentDTO> studentDTOList = studentList.stream()
				.map(student -> copyStudentDtoFromEntityOpt(Optional.of(student)).get()).collect(Collectors.toList());

		return studentDTOList;
	}

	public StudentDTO findByStudentID(Long studentID) {
		
		Optional<Student> studentOpt = studentRepo.findById(studentID);
		
		if(! studentOpt.isPresent()) {
			throw new ResourceNotFoundExceptionHandler(String.format(ErrorMessageContainer.MESSAGE_TYPE_RESOURCE_NOT_FOUND.getMessageDetails(), "Student ID: " + studentID));
		} 
		
		return copyStudentDtoFromEntityOpt(studentOpt).get();		
	}

	public void deleteStudent(Long studentID) {
		

		Optional<Student> studentOpt = studentRepo.findById(studentID);
		
		if(! studentOpt.isPresent()) {
			throw new ResourceNotFoundExceptionHandler(String.format(ErrorMessageContainer.MESSAGE_TYPE_RESOURCE_NOT_FOUND.getMessageDetails(), "Student ID: " + studentID));
		} 
		
		studentRepo.delete(studentOpt.get());
	}

	public Optional<StudentDTO> copyStudentDtoFromEntityOpt(Optional<Student> studentOpt) {

		if (isStudentCopiable(studentOpt)) {
		return	copyStudentDtoFromEntity(studentOpt.get());
		}

		return Optional.empty();
	}

	public Optional<Student> copyStudentFromDtoOpt(Optional<StudentDTO> studentDtoOpt) {

		if (isStudentDtoCopiable(studentDtoOpt)) {
			return copyStudentFromDTO(studentDtoOpt.get());
		}

		return Optional.empty();
	}

	private boolean isStudentCopiable(Optional<Student> studentOpt) {

		Student student = studentOpt.orElseThrow(() -> new BadRequestExceptionHandler(
				String.format(ErrorMessageContainer.MESSAGE_TYPE_BAD_REQUEST.getMessageDetails(), "student")));

		if (StringUtils.isEmpty(student.getStudentID()))
			throw new BadRequestExceptionHandler(
					String.format(ErrorMessageContainer.MESSAGE_TYPE_BAD_REQUEST.getMessageDetails(), "studentID"));

		return true;
	}

	private Optional<StudentDTO> copyStudentDtoFromEntity(Student student) {

		StudentDTO studentDTO = new StudentDTO();
		BeanUtils.copyProperties(student, studentDTO);
		return Optional.of(studentDTO);

	}

	private boolean isStudentDtoCopiable(Optional<StudentDTO> studentDtoOpt) {

		StudentDTO studentDTO = studentDtoOpt.orElseThrow(() -> new BadRequestExceptionHandler(
				String.format(ErrorMessageContainer.MESSAGE_TYPE_BAD_REQUEST.getMessageDetails(), "studentDTO")));

		if (StringUtils.isEmpty(studentDTO.getStudentName()))
			throw new BadRequestExceptionHandler(
					String.format(ErrorMessageContainer.MESSAGE_TYPE_BAD_REQUEST.getMessageDetails(), "studentName"));

		return true;
	}

	private Optional<Student> copyStudentFromDTO(StudentDTO studentDto) {

		Student student = new Student();
		BeanUtils.copyProperties(studentDto, student);
		return Optional.of(student);

	}

}
