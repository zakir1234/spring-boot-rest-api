
package com.spring.endpoint;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.common.enums.MessageContainer;
import com.spring.dto.StudentDTO;
import com.spring.service.StudentService;

/**
 * 
 * @author Zakir
 *
 */

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;

		
	@PostMapping("/save")
	public ResponseEntity<?> saveStudent(@RequestBody StudentDTO studentDTO) {		
		studentService.saveOrUpdateStudent(studentDTO);		
		return new ResponseEntity<String>(MessageContainer.MESSAGE_SAVE_SUCCESS.getMessageDetails(), HttpStatus.CREATED);
	}
	
	@PutMapping(path="/update")
	public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentDTO) {		
		studentService.saveOrUpdateStudent(studentDTO);		
		return new ResponseEntity<String>(MessageContainer.MESSAGE_UPDATE_SUCCESS.getMessageDetails(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/find-all")
	public ResponseEntity<List<StudentDTO>> saveStudent() {	
		return new ResponseEntity<List<StudentDTO>>(studentService.findAllStudents(), HttpStatus.FOUND);		
	}
	
	
	@GetMapping("/find/{studentId}")
	public ResponseEntity<StudentDTO> editStudent(@PathVariable Long studentId) {	 
		return new ResponseEntity<StudentDTO>(studentService.findByStudentID(studentId), HttpStatus.FOUND);
	}
	
	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) {		
		studentService.deleteStudent(studentId);
		return new ResponseEntity<String>(MessageContainer.MESSAGE_DELETE_SUCCESS.getMessageDetails(), HttpStatus.OK);		
	}
	
}
