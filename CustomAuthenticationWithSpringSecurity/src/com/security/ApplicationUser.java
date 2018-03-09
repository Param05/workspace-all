package com.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class ApplicationUser {

	private final String email;

	public ApplicationUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection<GrantedAuthority> authorities,
			String email) {

		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

}
