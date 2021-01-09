package com.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Zakir
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
	
	private Long studentID;
	private String studentName;
	private int studentRoll;
	private String email;
	private String photoName;	
}
