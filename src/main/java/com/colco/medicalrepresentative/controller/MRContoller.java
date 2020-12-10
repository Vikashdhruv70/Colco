package com.colco.medicalrepresentative.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colco.medicalrepresentative.dto.DrugsDtoClass;
import com.colco.medicalrepresentative.dto.MRDtoClass;
import com.colco.medicalrepresentative.response.DrugResponseObject;
import com.colco.medicalrepresentative.response.ResponseStatus;
import com.colco.medicalrepresentative.service.MRService;


@RestController
public class MRContoller {

	 private static final Logger LOG = LoggerFactory.getLogger(MRContoller.class);
	 
	 @Autowired
	 MRService mrService;
	 
	 
	    /*
		 * createMr(@RequestBody MRDtoClass mrDto) will create the new MR and will store as many as drugs assign to him
		*/
		
	 
	 
	 @PostMapping(value="/create/mrprofile")
	 public ResponseEntity<ResponseStatus> createMr(@RequestBody MRDtoClass mrDto){
		 
		  LOG.trace(" -->ENTRY-->createMr() :: {}",mrDto);

	      LOG.trace("<--EXIT<--createMr() :: {}", mrDto);
	      
	      return ResponseEntity.ok(mrService.createNewMr(mrDto));
	 }
	 
	 
	 
	    /*
	    *  addnewDrug(@PathVariable Long mrMobileNo,@RequestBody DrugResponseObject drugdto) with this method admin can add new Drugs 
	    */
	 
	 
	 @PutMapping(value="/updateDrugandMr/{mrMobileNo}")
	 public ResponseEntity<ResponseStatus> addnewDrug(@PathVariable Long mrMobileNo,@RequestBody DrugResponseObject drugdto){
		 
		 LOG.trace(" -->ENTRY-->addnewDrug() :: {}",mrMobileNo,drugdto);

	     LOG.trace("<--EXIT<--addnewDrug() :: {}", mrMobileNo,drugdto);
	     
	     return ResponseEntity.ok(mrService.updateInfo(mrMobileNo,drugdto));
	 }
	 
	    /*
		 * updateDetailsMR(@PathVariable Long mrMobileNo,@RequestBody MRDtoClass mrDto) with this method ADMIN can update  of all  detail of  MR  . 
		 */
	 
	 @PutMapping(value="/updateRepresenUser/{mrMobileNo}")
	 public ResponseEntity<ResponseStatus> updateDetailsMR(@PathVariable Long mrMobileNo,@RequestBody MRDtoClass mrDto){
		 
		 LOG.trace(" -->ENTRY-->updateDetailsMR() :: {}",mrMobileNo,mrDto);

	     LOG.trace("<--EXIT<--updateDetailsMR() :: {}", mrMobileNo,mrDto);
	     
	     return ResponseEntity.ok(mrService.updateMRInfo(mrMobileNo,mrDto));
	 }
	 
	 
	    /*
		 * updateDrugInfo(String mrId,String drugName, DrugResponseObject drugdto) with this method ADMIN can update  of all  drugs related to MR  . 
		 */
	 
	 
	 @PutMapping(value="/updateDrug/{mrId}/{drugName}")
	 public ResponseEntity<ResponseStatus> updateDrug(@PathVariable String mrId,@PathVariable String drugName,@RequestBody DrugResponseObject drugdto){
		 
		 LOG.trace(" -->ENTRY-->updateDrug() :: {}",mrId,drugdto);

	     LOG.trace("<--EXIT<--updateDrug() :: {}", mrId,drugdto);
	     
	     return ResponseEntity.ok(mrService.updateDrugInfo(mrId,drugName,drugdto));
	 }
	 
	 
	 
	 /*
	  * deleteDetails(@PathVariable Long mrMobileNo) with this method ADMIN can Delete All MR related detail 
	  */
	 
	 @DeleteMapping(value="/deleteMR/{mrMobileNo}")
	 public ResponseEntity<ResponseStatus> deleteDetails(@PathVariable Long mrMobileNo){
		 LOG.trace(" -->ENTRY-->deleteDetails() :: {}",mrMobileNo);

	     LOG.trace("<--EXIT<--deleteDetails() :: {}", mrMobileNo);
	     
	     return ResponseEntity.ok(mrService.deleteMr(mrMobileNo));
	 }
	 
	 
	 /*
	  * getmrDetails() with this method ADMIN can list of all  MR detail without Drugs 
	 */
	 
	 @GetMapping(value="/getmrDetails")
	 public ResponseEntity<ResponseStatus> getmrDetails(){
		 LOG.trace(" -->ENTRY-->getmrDetails() :: {}");

	     LOG.trace("<--EXIT<--getmrDetails() :: {}");
	     
	     return ResponseEntity.ok(mrService.getDetai());
	 }
	 
	    /*
		 *  getDetails(@PathVariable Long mrMobileNo)with this method ADMIN can get of all  detail of MR  with Drugs by passing mobile no. 
		 */
	 
	 @GetMapping(value="/getDetails/{mrMobileNo}")
	 public ResponseEntity<ResponseStatus> getDetails(@PathVariable Long mrMobileNo){
		 LOG.trace(" -->ENTRY-->getDetails() :: {}",mrMobileNo);

	     LOG.trace("<--EXIT<--getDetails() :: {}",mrMobileNo);
	     
	     return ResponseEntity.ok(mrService.getMr(mrMobileNo));
	 }
	 
}
