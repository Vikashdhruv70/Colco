package com.colco.medicalrepresentative.service;

import org.springframework.stereotype.Service;

import com.colco.medicalrepresentative.dto.DrugsDtoClass;
import com.colco.medicalrepresentative.dto.MRDtoClass;
import com.colco.medicalrepresentative.response.DrugResponseObject;
import com.colco.medicalrepresentative.response.ResponseStatus;

@Service
public interface MRService {

	ResponseStatus createNewMr(MRDtoClass mrDto);

	ResponseStatus updateInfo(Long mrMobileNo,DrugResponseObject drugdto);

	ResponseStatus deleteMr(Long mrMobileNo);

	ResponseStatus getDetai();

	ResponseStatus getMr(Long mrMobileNo);

	ResponseStatus updateMRInfo(Long mrMobileNo, MRDtoClass mrDto);

	ResponseStatus updateDrugInfo(String mrId, String drugName, DrugResponseObject drugdto);

}
