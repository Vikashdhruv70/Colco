package com.colco.medicalrepresentative.dto;

public class DrugsDtoClass {

	
	private String drugName;
	private Double drugPrice;
	private Integer drugQuantity;
	private String drugCompanyName;
	private MRDtoClass mrDto;
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
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
	public MRDtoClass getMrDto() {
		return mrDto;
	}
	public void setMrDto(MRDtoClass mrDto) {
		this.mrDto = mrDto;
	}
	
	@Override
	public String toString() {
		return "DrugsDtoClass [ drugName=" + drugName + ", drugPrice=" + drugPrice
				+ ", drugQuantity=" + drugQuantity + ", drugCompanyName=" + drugCompanyName + ", mrDto=" + mrDto + "]";
	}
	
	
}
