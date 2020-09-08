package com.habibank.payload.request;

import javax.validation.constraints.NotBlank;

/*** part of the POJO classes for the Restful API service  
 * Payload class for 
 * LoginRequest -> username, password
 */
public class LoginRequest {
    @NotBlank
	private String username;

	@NotBlank
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
