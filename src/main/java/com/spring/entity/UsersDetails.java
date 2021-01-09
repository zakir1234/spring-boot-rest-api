package com.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "user_details")
@EntityListeners(AuditingEntityListener.class)
public class UsersDetails extends Auditable implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_details_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loginUserDetailsId;
	
	@Column(name = "username", unique = true)
	private String username;
	
	@Column(name = "user_type")
	private String userTypeId;
	

	public Long getLoginUserDetailsId() {
		return loginUserDetailsId;
	}

	public void setLoginUserDetailsId(Long loginUserDetailsId) {
		this.loginUserDetailsId = loginUserDetailsId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(String userTypeId) {
		this.userTypeId = userTypeId;
	}

}
