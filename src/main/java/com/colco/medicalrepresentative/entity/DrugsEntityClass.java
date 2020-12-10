package com.colco.medicalrepresentative.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="drugs_details")
public class DrugsEntityClass {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="drug_id",nullable = false)
	private String drugId;
	
	@Column(name="drug_name")
	private String drugName;
	
	@Column(name="drug_price")
	private Double drugPrice;
	
	@Column(name="drug_quantity")
	private Integer drugQuantity;
	
	@Column(name="drug_companyName")
	private String drugCompanyName;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mr_id")
	private MREntityClass mrInfo;


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

	
	
	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	@Override
	public String toString() {
		return "DrugsEntityClass [drugId=" + drugId + ", drugName=" + drugName + ", drugPrice=" + drugPrice
				+ ", drugQuantity=" + drugQuantity + ", drugCompanyName=" + drugCompanyName + ", mrInfo=" + mrInfo
				+ "]";
	}

	public MREntityClass getMrInfo() {
		return mrInfo;
	}

	public void setMrInfo(MREntityClass mrInfo) {
		this.mrInfo = mrInfo;
	}

	public DrugsEntityClass() {
		super();
	}

	
	
	
	
}
