package com.colco.medicalrepresentative.dto;

import java.util.List;

public class MRDtoClass {

	
	private String mrName;
	private Long mrMobileNo;
	private String mrAddress;
	private String createdBy;
	private String updateBy;
	private List<DrugsDtoClass> drugsDto;
	

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
	
	
	public List<DrugsDtoClass> getDrugsDto() {
		return drugsDto;
	}
	public void setDrugsDto(List<DrugsDtoClass> drugsDto) {
		this.drugsDto = drugsDto;
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
	@Override
	public String toString() {
		return "MRDtoClass [mrName=" + mrName + ", mrMobileNo=" + mrMobileNo + ", mrAddress="
				+ mrAddress + ", createdBy=" + createdBy + ", updateBy=" + updateBy + ", drugsDto=" + drugsDto + "]";
	}

}
