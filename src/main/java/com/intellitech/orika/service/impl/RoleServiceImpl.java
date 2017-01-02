package com.intellitech.orika.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intellitech.orika.model.Role;
import com.intellitech.orika.model.dto.RoleDto;
import com.intellitech.orika.model.mapper.RoleMapper;
import com.intellitech.orika.repository.RoleRepository;
import com.intellitech.orika.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	@Transactional(readOnly=true)
	public RoleDto findById(Integer roleId) {
		try {
			Role role=roleRepository.findOne(roleId);
			return roleMapper.map(role, RoleDto.class);
		} catch (Exception e) {
			return null;
		}
		
	}

}
