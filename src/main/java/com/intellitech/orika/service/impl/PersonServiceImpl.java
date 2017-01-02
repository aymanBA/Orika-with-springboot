package com.intellitech.orika.service.impl;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intellitech.orika.model.Person;
import com.intellitech.orika.model.dto.PersonDto;
import com.intellitech.orika.repository.PersonRepository;
import com.intellitech.orika.service.PersonService;

import ma.glasnost.orika.MapperFacade;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private MapperFacade personMapping;

	@Override
	@Transactional(readOnly = true)
	public PersonDto findById(Long personId) {
		try {
			Person person = personRepository.findOne(personId);
			if (person == null) {
				throw new NoResultException("User not found");
			}
			System.out.println("22");
			return personMapping.map(person, PersonDto.class);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Person addPerson(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

}
