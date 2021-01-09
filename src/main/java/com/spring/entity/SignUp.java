package com.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "sign_up")

public class SignUp {
	@Id
	@Column(name = "signup_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long signUpId;

	@Column(name = "user_name", nullable=false, unique=true)
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "contact_no", unique = true, nullable = false)
	private String contactNo;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "present_Address")
	private String presentAddress;
	
	@Column(name="bn_present_address")
	private String bnPresentAddress;

	@Column(name = "current_workspace")
	private String currentWorkspace;

	@Column(name = "doctor_designation")
	private String docotorDesignation;

	@Column(name = "signed_up_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date signedUpDate;
	
	@Column(name="password_recovery_key")
	@NotNull
	private String passwordRecoveryKey;
}
