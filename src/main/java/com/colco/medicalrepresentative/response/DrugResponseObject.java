package com.colco.medicalrepresentative.response;

import com.colco.medicalrepresentative.dto.MRDtoClass;
import com.colco.medicalrepresentative.entity.MREntityClass;

public class DrugResponseObject {

  
	private String drugName;
	private Double drugPrice;
	private Integer drugQuantity;
	private String drugCompanyName;
	private String mrResponseObject;
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	
	public String getMrResponseObject() {
		return mrResponseObject;
	}
	public void setMrResponseObject(String mrResponseObject) {
		this.mrResponseObject = mrResponseObject;
	}
	public Double getDrugPrice() {
		return drugPrice;
	}
	public void setDrugPrice(Double drugPrice) {
		this.drugPrice = drugPrice;
	}
	public Integer getDrugQuantity() {
		return drugQuantity;
	}
	public void setDrugQuantity(Integer drugQuantity) {
		this.drugQuantity = drugQuantity;
	}
	public String getDrugCompanyName() {
		return drugCompanyName;
	}
	public void setDrugCompanyName(String drugCompanyName) {
		this.drugCompanyName = drugCompanyName;
	}
	
	
	@Override
	public String toString() {
		return "DrugResponseObject [drugName=" + drugName + ", drugPrice=" + drugPrice + ", drugQuantity="
				+ drugQuantity + ", drugCompanyName=" + drugCompanyName + "]";
	}
	
}
