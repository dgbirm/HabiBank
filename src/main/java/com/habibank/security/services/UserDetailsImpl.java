package com.habibank.security.services;

import java.util.Collection;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.habibank.model.User;

/** User details provides core user information.
Implementations are not used directly by Spring Security for security purposes. They simply store user information which is later encapsulated into Authentication objects. This allows non-security related user information (such as email addresses, telephone numbers etc) to be stored in a convenient location.
Concrete implementations must take particular care to ensure the non-null  */


public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	//private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String username, String email, String password
			/*,Collection<? extends GrantedAuthority> authorities*/) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		//this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user) {/* 
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList()); */

		return new UserDetailsImpl(
				user.getUserID(), 
				user.getUserName(), 
				user.getEmail(),
				user.getPassword()
				/*, authorities*/);
	}

/* 	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	} */

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

	//Had to include getAuthorities()
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
}