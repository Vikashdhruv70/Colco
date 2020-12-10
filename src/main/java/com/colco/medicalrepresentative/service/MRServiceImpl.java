package com.colco.medicalrepresentative.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.colco.medicalrepresentative.dto.DrugsDtoClass;
import com.colco.medicalrepresentative.dto.MRDtoClass;
import com.colco.medicalrepresentative.entity.DrugsEntityClass;
import com.colco.medicalrepresentative.entity.MREntityClass;
import com.colco.medicalrepresentative.exceptionhandle.ExceptionHandle;
import com.colco.medicalrepresentative.exceptionhandle.StatusResponse;
import com.colco.medicalrepresentative.repositry.DrugRepositry;
import com.colco.medicalrepresentative.repositry.MRRepositry;
import com.colco.medicalrepresentative.response.DrugResponseObject;
import com.colco.medicalrepresentative.response.MRResponseObject;
import com.colco.medicalrepresentative.response.ResponseCode;
import com.colco.medicalrepresentative.response.ResponseStatus;

@Service
public class MRServiceImpl implements MRService {

	@Autowired
	MRRepositry mrRepositry;
	
	@Autowired
	DrugRepositry drugRepositry;
	
	
	
	
	/*
	 * createNewMr(MRDtoClass mrDto) will create the new MR and will store as many as drugs assign to him
	*/
	
	@Override
	public ResponseStatus createNewMr(MRDtoClass mrDto) {
		
		MRResponseObject mrResponseObject= new MRResponseObject();
		
		
	List<DrugsEntityClass> drugdto=new ArrayList<DrugsEntityClass>();
	
		
		
	MREntityClass mrInfo=mrInfo=new MREntityClass();
		Optional<MREntityClass> optionalMrDetail =mrRepositry.findByMrMobileNo(mrDto.getMrMobileNo());
		
if(optionalMrDetail.isPresent()) {

			
			throw new ExceptionHandle(StatusResponse.MR_ALREADY_EXIST, 
					StatusResponse.MR_ALREADY_EXIST.getCode(),
					StatusResponse.MR_ALREADY_EXIST.getReason());
			
		}else {
			
		
	
			mrInfo.setMrName(mrDto.getMrName());
			mrInfo.setMrMobileNo(mrDto.getMrMobileNo());
			mrInfo.setMrAddress(mrDto.getMrAddress());
			mrInfo.setCreatedAt(System.currentTimeMillis());
			mrInfo.setCreatedBy(mrDto.getCreatedBy());
			mrInfo.setUpdatedAt(System.currentTimeMillis());
			mrInfo.setUpdateBy(mrDto.getUpdateBy());
			
			mrRepositry.save(mrInfo);
			
		   mrDto.getDrugsDto().forEach(drugInfo->{
			DrugsEntityClass drugInf = new DrugsEntityClass();
			drugInf.setDrugCompanyName(drugInfo.getDrugCompanyName());
			drugInf.setDrugName(drugInfo.getDrugName());
			drugInf.setDrugPrice(drugInfo.getDrugPrice());
			drugInf.setDrugQuantity(drugInfo.getDrugQuantity());
			drugInf.setMrInfo(mrInfo);
			
			drugRepositry.save(drugInf);		
			drugdto.add(drugInf);
		});	
		   
			mrInfo.setDrugsInfo(drugdto);
		
			mrRepositry.save(mrInfo);
			
			mrResponseObject.setMrId(mrInfo.getMrId());
			mrResponseObject.setMrName(mrInfo.getMrName());
			mrResponseObject.setMrMobileNo(mrInfo.getMrMobileNo());
			mrResponseObject.setCreatedBy(mrInfo.getCreatedBy());
			mrResponseObject.setCreatedAt(mrInfo.getCreatedAt());
			mrResponseObject.setUpdateBy(mrInfo.getCreatedBy());
			mrResponseObject.setUpdateAt(mrInfo.getUpdatedAt());
			
		List<DrugResponseObject> listDrugsRes= new ArrayList<DrugResponseObject>();
			
			  mrInfo.getDrugsInfo().forEach(drugInfo->{
				  DrugResponseObject drugResponseObject= new DrugResponseObject();
					drugResponseObject.setDrugCompanyName(drugInfo.getDrugCompanyName());
					drugResponseObject.setDrugName(drugInfo.getDrugName());
					drugResponseObject.setDrugPrice(drugInfo.getDrugPrice());
					drugResponseObject.setDrugQuantity(drugInfo.getDrugQuantity());
					drugResponseObject.setMrResponseObject(mrInfo.getMrId());
					
					listDrugsRes.add(drugResponseObject);
				});
			
		mrResponseObject.setDrugsResponseObject(listDrugsRes);
		
			
		}
		
		
		
		return new ResponseStatus(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getReasonPhrase(),mrResponseObject);
	}


   /*
    * updateInfo(Long mrMobileNo,DrugResponseObject drugdto) with this method admin can add new Drugs 
    */

	@Override
	public ResponseStatus updateInfo(Long mrMobileNo,DrugResponseObject drugdto) {
		
		Optional<MREntityClass> optionalMrDetail =mrRepositry.findByMrMobileNo(mrMobileNo);
		MREntityClass mrinfo=optionalMrDetail.get();
		
		
		if(!optionalMrDetail.isPresent()) {
			
			throw new ExceptionHandle(StatusResponse.MR_DOES_NOT_EXIST, 
					StatusResponse.MR_DOES_NOT_EXIST.getCode(), 
					StatusResponse.MR_DOES_NOT_EXIST.getReason());
		}else if(optionalMrDetail.isPresent()) {
			
			Optional<DrugsEntityClass> optionalDrugEntity=drugRepositry.findByDrugName(drugdto.getDrugName());
			
			if(optionalDrugEntity.isPresent()) {
				throw new ExceptionHandle(StatusResponse.DRUG_ALREADY_PRESENT, 
						StatusResponse.DRUG_ALREADY_PRESENT.getCode(), 
						StatusResponse.DRUG_ALREADY_PRESENT.getReason());
			
			}else {
			
				DrugsEntityClass druginfo=new DrugsEntityClass();
				
				druginfo.setDrugCompanyName(drugdto.getDrugCompanyName());
				druginfo.setDrugName(drugdto.getDrugName());
				druginfo.setDrugPrice(drugdto.getDrugPrice());
				druginfo.setDrugQuantity(drugdto.getDrugQuantity());
				druginfo.setMrInfo(mrinfo);
					drugRepositry.save(druginfo);
					
						mrRepositry.save(mrinfo);
			
			
			}

		
		}
		
		return new ResponseStatus(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getReasonPhrase());
	}


/*
 * deleteMr(Long mrMobileNo) with this method ADMIN can Delete All MR related detail 
 */

	@Override
	public ResponseStatus deleteMr(Long mrMobileNo) {

		Optional<MREntityClass> optionalMrDetail =mrRepositry.findByMrMobileNo(mrMobileNo);
		MREntityClass mrEntity=optionalMrDetail.get();
		if(mrEntity!=null) {
			mrRepositry.delete(mrEntity);
		}else {
			throw new ExceptionHandle(StatusResponse.MR_DOES_NOT_EXIST, 
					StatusResponse.MR_DOES_NOT_EXIST.getCode(), 
					StatusResponse.MR_DOES_NOT_EXIST.getReason());
		}
		
		return new ResponseStatus(ResponseCode.MR_DRUGS_DELETED.getCode(), ResponseCode.MR_DRUGS_DELETED.getReasonPhrase());
	}



/*
 * getDetai() with this method ADMIN can list of all  MR detail without Drugs 
 */

	@Override
	public ResponseStatus getDetai() {
		List<MRResponseObject>mrResponseObject1= new ArrayList<MRResponseObject>();
		Iterable<MREntityClass> optionalMREntityClass=null;
		List<DrugsEntityClass> drugdto=new ArrayList<DrugsEntityClass>();
		optionalMREntityClass=mrRepositry.findAll();
		//while(optionalMREntityClass.iterator().hasNext()) {
		if(optionalMREntityClass!=null) {
			optionalMREntityClass.forEach(mr->{
            MRResponseObject mrResponseObject=new MRResponseObject();
           mrResponseObject.setMrId(mr.getMrId());
            mrResponseObject.setMrName(mr.getMrName());
            mrResponseObject.setMrMobileNo(mr.getMrMobileNo());
            mrResponseObject.setCreatedBy(mr.getCreatedBy());
            mrResponseObject.setCreatedAt(mr.getCreatedAt());
            mrResponseObject.setUpdateBy(mr.getCreatedBy());
			mrResponseObject.setUpdateAt(mr.getUpdatedAt());
			mrResponseObject1.add(mrResponseObject);
				
			});
		
			
		}
		
	
		
		return new ResponseStatus(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getReasonPhrase(),mrResponseObject1);
	}


	/*
	 * (Long mrMobileNo) with this method ADMIN can get of all  detail of MR  with Drugs by passing mobile no. 
	 */

	@Override
	public ResponseStatus getMr(Long mrMobileNo) {
		Optional<MREntityClass> optionalMREntityClass =mrRepositry.findByMrMobileNo(mrMobileNo);
		MRResponseObject mrResponseObject= new MRResponseObject();
		MREntityClass mrEntity=optionalMREntityClass.get();
		if(mrEntity!=null) {
		


				mrResponseObject.setMrId(mrEntity.getMrId());
				mrResponseObject.setMrName(mrEntity.getMrName());
				mrResponseObject.setMrMobileNo(mrEntity.getMrMobileNo());
				mrResponseObject.setCreatedBy(mrEntity.getCreatedBy());
				mrResponseObject.setCreatedAt(mrEntity.getCreatedAt());
				mrResponseObject.setUpdateBy(mrEntity.getCreatedBy());
				mrResponseObject.setUpdateAt(mrEntity.getUpdatedAt());
				
			List<DrugResponseObject> listDrugsRes= new ArrayList<DrugResponseObject>();
				
			mrEntity.getDrugsInfo().forEach(drugInfo->{
					  DrugResponseObject drugResponseObject= new DrugResponseObject();
						drugResponseObject.setDrugCompanyName(drugInfo.getDrugCompanyName());
						drugResponseObject.setDrugName(drugInfo.getDrugName());
						drugResponseObject.setDrugPrice(drugInfo.getDrugPrice());
						drugResponseObject.setDrugQuantity(drugInfo.getDrugQuantity());
						drugResponseObject.setMrResponseObject(mrEntity.getMrId());
						
						listDrugsRes.add(drugResponseObject);
					});
				
			mrResponseObject.setDrugsResponseObject(listDrugsRes);
			
			}else {
			throw new ExceptionHandle(StatusResponse.MR_DOES_NOT_EXIST, 
					StatusResponse.MR_DOES_NOT_EXIST.getCode(), 
					StatusResponse.MR_DOES_NOT_EXIST.getReason());
		}
		
		return new ResponseStatus(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getReasonPhrase(),mrResponseObject);
	}


	/*
	 * updateMRInfo(Long mrMobileNo, MRDtoClass mrDto) with this method ADMIN can update  of all  detail of  MR  . 
	 */
	
	@Override
	public ResponseStatus updateMRInfo(Long mrMobileNo, MRDtoClass mrDto) {
		Optional<MREntityClass> optionalMrDetail =mrRepositry.findByMrMobileNo(mrDto.getMrMobileNo());
		MRResponseObject mrResponseObject= new MRResponseObject();
        if(optionalMrDetail.isPresent()) {

			MREntityClass mrInfo = optionalMrDetail.get();
			mrInfo.setMrName(mrDto.getMrName());
			mrInfo.setMrMobileNo(mrDto.getMrMobileNo());
			mrInfo.setMrAddress(mrDto.getMrAddress());
			mrInfo.setCreatedAt(System.currentTimeMillis());
			mrInfo.setCreatedBy(mrDto.getCreatedBy());
			mrInfo.setUpdatedAt(System.currentTimeMillis());
			mrInfo.setUpdateBy(mrDto.getUpdateBy());
			
			mrRepositry.save(mrInfo);
			
			mrResponseObject.setMrId(mrInfo.getMrId());
			mrResponseObject.setMrName(mrInfo.getMrName());
			mrResponseObject.setMrMobileNo(mrInfo.getMrMobileNo());
			mrResponseObject.setCreatedBy(mrInfo.getCreatedBy());
			mrResponseObject.setCreatedAt(mrInfo.getCreatedAt());
			mrResponseObject.setUpdateBy(mrInfo.getCreatedBy());
			mrResponseObject.setUpdateAt(System.currentTimeMillis());
		
        }
        return new ResponseStatus(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getReasonPhrase(),mrResponseObject);
	}



	/*
	 * updateDrugInfo(String mrId,String drugName, DrugResponseObject drugdto) with this method ADMIN can update  of all  drugs related to MR  . 
	 */
	@Override
	public ResponseStatus updateDrugInfo(String mrId,String drugName, DrugResponseObject drugdto) {
		
		Optional<MREntityClass> optionalMrDetail =mrRepositry.findByMrId(mrId);
		MREntityClass mrinfo=optionalMrDetail.get();
		Optional<DrugsEntityClass> optionaldrugInfo=drugRepositry.findByDrugName(drugName);
		
		 if(optionaldrugInfo.isPresent()) {
			
			DrugsEntityClass druginfo=optionaldrugInfo.get();
			
			druginfo.setDrugCompanyName(drugdto.getDrugCompanyName());
			druginfo.setDrugName(drugdto.getDrugName());
			druginfo.setDrugPrice(drugdto.getDrugPrice());
			druginfo.setDrugQuantity(drugdto.getDrugQuantity());
			druginfo.setMrInfo(mrinfo);
				drugRepositry.save(druginfo);	
				
				
		 }else {
			 throw new ExceptionHandle(StatusResponse.DRUG_NOT_PRESENT, 
					 StatusResponse.DRUG_NOT_PRESENT.getCode(), 
					 StatusResponse.DRUG_NOT_PRESENT.getReason());
		 }
		 DrugResponseObject drugResponseObject=new DrugResponseObject();
			drugResponseObject.setDrugCompanyName(drugdto.getDrugCompanyName());
			drugResponseObject.setDrugName(drugdto.getDrugName());
			drugResponseObject.setDrugPrice(drugdto.getDrugPrice());
			drugResponseObject.setDrugQuantity(drugdto.getDrugQuantity());
			drugResponseObject.setMrResponseObject(mrinfo.getMrId());
				
		 return new ResponseStatus(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getReasonPhrase(),drugResponseObject);
	}
	
	
}
