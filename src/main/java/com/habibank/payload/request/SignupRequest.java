package com.habibank.payload.request;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.habibank.repo.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Email;


//TODO:
public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 25)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    	
	@Autowired
	private CustomerRepository custRepo;

	@NotBlank
    private long userId;
    


    public Long getUserID() {
		return userId;
	}
    
    /**
     * @return long return the userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }


    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = this.custRepo.findById(this.userId).get().getUserName();
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = this.custRepo.findById(this.userId).get().getEmail();
    }

     /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }    

}
