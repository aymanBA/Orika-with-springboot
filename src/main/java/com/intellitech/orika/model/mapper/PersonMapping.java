package com.intellitech.orika.model.mapper;

import org.springframework.stereotype.Component;

import com.intellitech.orika.model.Person;
import com.intellitech.orika.model.dto.PersonDto;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class PersonMapping extends ConfigurableMapper{

	protected void configure(MapperFactory factory) {
	    factory.classMap(Person.class, PersonDto.class)
	      .field("id", "id")
	      .field("firstName", "firstName")
	      .field("lastName", "lastName")
	      .byDefault()
	      .register();      
	  }
}
