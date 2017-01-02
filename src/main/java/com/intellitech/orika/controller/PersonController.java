package com.intellitech.orika.controller;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intellitech.orika.model.dto.PersonDto;
import com.intellitech.orika.service.PersonService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@ApiOperation(value="Get person by id",notes="get user")
	@RequestMapping(value="/{personId}",method=RequestMethod.GET)
	@ApiResponses(value={
			@ApiResponse(code=200,message="Success",response=PersonDto.class),
			@ApiResponse(code=401,message="Unauthorized"),
			@ApiResponse(code=403,message="Forbidden"),
			@ApiResponse(code=404,message="Not Found"),
			@ApiResponse(code=500,message="Failure")
			})
	public ResponseEntity<PersonDto> getPersonById(@PathVariable Long personId){
		try {
			return new ResponseEntity<PersonDto>(personService.findById(personId), HttpStatus.OK);
		} 
		catch (NoResultException nre) {
			System.out.println("11");
			return new ResponseEntity<PersonDto>(HttpStatus.NOT_FOUND);	
		}
		catch (Exception e) {
			return null;
		}
	}
}
