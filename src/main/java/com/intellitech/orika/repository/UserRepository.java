package com.intellitech.orika.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intellitech.orika.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
