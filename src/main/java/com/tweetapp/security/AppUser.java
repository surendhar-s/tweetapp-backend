package com.tweetapp.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tweetapp.entities.UsersEntity;

@SuppressWarnings("serial")
public class AppUser implements UserDetails {

	private UsersEntity user; // entity reference
	private Collection<? extends GrantedAuthority> authorities; // to store role
																// details

	public AppUser(UsersEntity user) {
		this.authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role))
				.collect(Collectors.toList());
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getLoginId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
