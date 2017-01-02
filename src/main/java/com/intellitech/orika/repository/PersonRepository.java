package com.intellitech.orika.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intellitech.orika.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
