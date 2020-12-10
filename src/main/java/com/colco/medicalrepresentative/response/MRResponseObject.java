package com.colco.medicalrepresentative.response;

import java.util.List;

import com.colco.medicalrepresentative.dto.DrugsDtoClass;
import com.colco.medicalrepresentative.entity.DrugsEntityClass;

public class MRResponseObject {

	private String mrId;
	private String mrName;
	private Long mrMobileNo;
	private String mrAddress;
	private String createdBy;
	private Long createdAt;
	private String updateBy;
	private Long updateAt;
	private List<DrugResponseObject> drugsResponseObject;
	
	

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

	public List<DrugResponseObject> getDrugsResponseObject() {
		return drugsResponseObject;
	}
	public void setDrugsResponseObject(List<DrugResponseObject> drugsResponseObject) {
		this.drugsResponseObject = drugsResponseObject;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	public Long getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}
	public Long getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}
	@Override
	public String toString() {
		return "MRResponseObject [mrId=" + mrId + ", mrName=" + mrName + ", mrMobileNo=" + mrMobileNo + ", mrAddress="
				+ mrAddress + ", createdBy=" + createdBy + ", createdAt=" + createdAt + ", updateBy=" + updateBy
				+ ", updateAt=" + updateAt + ", drugsResponseObject=" + drugsResponseObject + "]";
	}

}
