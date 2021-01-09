package com.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Zakir
 *
 */
@Getter
@Setter
@Entity
@Table(name="student")
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "studentID")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentID;
	
	@Column(name = "student_name")
	private String studentName;
	
	@Column(name = "student_roll")
	private int studentRoll;
	
	@Column(name = "email")
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="teacher_id")
	private Teacher teacher;

	public Long getStudentID() {
		return studentID;
	}

	public void setStudentID(Long studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentRoll() {
		return studentRoll;
	}

	public void setStudentRoll(int studentRoll) {
		this.studentRoll = studentRoll;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
