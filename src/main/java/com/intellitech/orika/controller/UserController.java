package com.intellitech.orika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intellitech.orika.model.dto.UserDto;
import com.intellitech.orika.service.RoleService;
import com.intellitech.orika.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public String defaultwelcome(Model model){
		System.out.println("hello");
		return "hello";
	}
	
	
	@ApiOperation(value="Save a new user",notes="add new user")
	@RequestMapping(value="/saveNewUser/{roleId}",method=RequestMethod.POST)
	@ApiResponses(value={
			@ApiResponse(code=200,message="Success",response=UserDto.class),
			@ApiResponse(code=401,message="Unauthorized"),
			@ApiResponse(code=403,message="Forbidden"),
			@ApiResponse(code=404,message="Not Found"),
			@ApiResponse(code=500,message="Failure")
			})
	public ResponseEntity<UserDto> addNewUser(@PathVariable Integer roleId,@RequestBody UserDto userDto){
		userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		UserDto userSaved=userService.saveUser(userDto);
		return new ResponseEntity<UserDto>(userSaved, HttpStatus.OK);
		
	}
	
	@ApiOperation(value="get user by id",notes="add new user")
	@RequestMapping(value="/get/{userId}",method=RequestMethod.GET)
	@ApiResponses(value={
			@ApiResponse(code=200,message="Success",response=UserDto.class),
			@ApiResponse(code=401,message="Unauthorized"),
			@ApiResponse(code=403,message="Forbidden"),
			@ApiResponse(code=404,message="Not Found"),
			@ApiResponse(code=500,message="Failure")
			})
	public ResponseEntity<UserDto> getById(@PathVariable Long userId){
		return new ResponseEntity<UserDto>(userService.findById(userId), HttpStatus.OK);
	}
}
