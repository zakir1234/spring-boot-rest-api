package com.spring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="teacher_id")
	private Long teacherId;
	
	@Column(name="teacher_name")
	private String teacherName;
	
	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	private Set<Student> students = new HashSet<>();
	 

}
