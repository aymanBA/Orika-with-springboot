package com.intellitech.orika.service;

import com.intellitech.orika.model.dto.UserDto;

public interface UserService {

	public UserDto findByUsername(String username);
	public UserDto saveUser(UserDto userDto);
	public UserDto findById(Long userId);
}
