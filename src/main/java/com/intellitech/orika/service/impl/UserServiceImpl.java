package com.intellitech.orika.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intellitech.orika.model.User;
import com.intellitech.orika.model.dto.UserDto;
import com.intellitech.orika.repository.UserRepository;
import com.intellitech.orika.service.UserService;

import ma.glasnost.orika.MapperFacade;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MapperFacade userMapper;

	@Override
	public UserDto findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto saveUser(UserDto userDto) {
		try {
			User user = userMapper.map(userDto, User.class);
			User userSaved = userRepository.save(user);
			return userMapper.map(userSaved, UserDto.class);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	@Transactional(readOnly = true)
	public UserDto findById(Long userId) {
		User user = userRepository.findOne(userId);
		return userMapper.map(user, UserDto.class);
	}

}
