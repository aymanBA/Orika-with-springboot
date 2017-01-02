package com.intellitech.orika.service;

import com.intellitech.orika.model.Person;
import com.intellitech.orika.model.dto.PersonDto;

public interface PersonService {

	public PersonDto findById(Long personId);
	public Person addPerson(Person person);
}
