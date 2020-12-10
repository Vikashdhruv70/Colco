package com.colco.medicalrepresentative.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="mr_info")
public class MREntityClass {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="mr_id",nullable = false)
	private String mrId;
	
	@Column(name="mr_name")
	private String mrName;
	
	@Column(name="mr_mobileno")
	private Long mrMobileNo;
	
	@Column(name="mr_address")
	private String mrAddress;
	
	@Column(name="mr_createdat")
	private Long createdAt;
	
	@Column(name="mr_createdby")
	private String createdBy;
	
	@Column(name="mr_updatedat")
	private Long updatedAt;
	
	@Column(name="mr_updatedby")
	private String updateBy;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "mrInfo")
	private List<DrugsEntityClass> drugsInfo;

	
	public MREntityClass() {
		super();
	}

	public String getMrId() {
		return mrId;
	}

	public void setMrId(String mrId) {
		this.mrId = mrId;
	}

	public String getMrName() {
		return mrName;
	}

	public void setMrName(String mrName) {
		this.mrName = mrName;
	}

	public Long getMrMobileNo() {
		return mrMobileNo;
	}

	public void setMrMobileNo(Long mrMobileNo) {
		this.mrMobileNo = mrMobileNo;
	}

	public String getMrAddress() {
		return mrAddress;
	}

	public void setMrAddress(String mrAddress) {
		this.mrAddress = mrAddress;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Long updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public List<DrugsEntityClass> getDrugsInfo() {
		return drugsInfo;
	}

	public void setDrugsInfo(List<DrugsEntityClass> drugsInfo) {
		this.drugsInfo = drugsInfo;
	}

	@Override
	public String toString() {
		return "MREntityClass [mrId=" + mrId + ", mrName=" + mrName + ", mrMobileNo=" + mrMobileNo + ", mrAddress="
				+ mrAddress + ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", updatedAt=" + updatedAt
				+ ", updateBy=" + updateBy + ", drugsInfo=" + drugsInfo + "]";
	}
	
		
	
}
