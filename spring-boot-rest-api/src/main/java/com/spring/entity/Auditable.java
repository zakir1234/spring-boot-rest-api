package com.spring.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@MappedSuperclass
@Data
public class Auditable {

	@Column(name = "created_date")
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "modified_date")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	@Column(name = "created_by")
	@CreatedBy
	private String createdBy;

	@Column(name = "modified_by")
	@LastModifiedBy
	private String modifiedBy;

}
