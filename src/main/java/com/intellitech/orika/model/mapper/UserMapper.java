package com.intellitech.orika.model.mapper;

import org.springframework.stereotype.Component;

import com.intellitech.orika.model.User;
import com.intellitech.orika.model.dto.UserDto;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class UserMapper extends ConfigurableMapper{

	protected void configure(MapperFactory factory) {
	    factory.classMap(User.class, UserDto.class)
	      .field("id", "id")
	      .field("username", "username")
	      .field("password", "password")
	      .field("role", "roleDto")
	      .byDefault()
	      .register();      
	  }
}
