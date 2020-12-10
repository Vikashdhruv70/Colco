package com.colco.medicalrepresentative.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colco.medicalrepresentative.dto.DrugsDtoClass;
import com.colco.medicalrepresentative.entity.DrugsEntityClass;

@Repository
public interface DrugRepositry extends JpaRepository<DrugsEntityClass, Integer>{

	Optional<DrugsEntityClass> findByDrugName(String  drugName);

}
