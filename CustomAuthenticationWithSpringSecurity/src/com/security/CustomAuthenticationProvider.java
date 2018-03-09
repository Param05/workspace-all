package com.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.bankapp.user.model.User;
import com.bankapp.user.model.UserRole;
import com.bankapp.user.service.MyUserDetailService;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private MyUserDetailService myUserDetailService;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String userName = authentication.getName().trim();
		String password = authentication.getCredentials().toString().trim();

		User user = myUserDetailService.loadUserByUsername(userName);
		List<GrantedAuthority> authorities = buildUserAuthority(user
				.getUserRole());
		return new UsernamePasswordAuthenticationToken(user, password,
				authorities);

	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				setAuths);
		return Result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
