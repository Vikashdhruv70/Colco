package com.colco.medicalrepresentative.repositry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colco.medicalrepresentative.dto.MRDtoClass;
import com.colco.medicalrepresentative.entity.MREntityClass;
import com.colco.medicalrepresentative.response.MRResponseObject;
import com.colco.medicalrepresentative.response.ResponseStatus;

@Repository
public interface MRRepositry extends JpaRepository<MREntityClass, Integer>{

	

	Optional<MREntityClass> findByMrMobileNo(Long mrMobileNo);

	Optional<MREntityClass> findByMrId(String mrId);

	

	

	

}
