package com.intellitech.orika.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intellitech.orika.model.dto.RoleDto;
import com.intellitech.orika.model.dto.UserDto;
import com.intellitech.orika.service.UserService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (username.trim().isEmpty()) {
			throw new UsernameNotFoundException("username is empty");
		}

		UserDto userDto = userService.findByUsername(username);

		if (userDto == null) {
			throw new UsernameNotFoundException("User " + username + " not found");
		}
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(userDto.getUsername(), userDto.getPassword(), enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, getGrantedAuthorities(userDto));

	}

	private List<GrantedAuthority> getGrantedAuthorities(UserDto userDto) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		RoleDto role = userDto.getRoleDto();
		authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		return authorities;
	}

}
