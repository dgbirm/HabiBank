package com.habibank.controller;

import javax.validation.Valid;

import com.habibank.payload.request.LoginRequest;
import com.habibank.payload.request.SignupRequest;
import com.habibank.payload.response.MessageResponse;
import com.habibank.repo.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controller for handling login/logout logic of front end
 */

// auth
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/auth")

public class AuthController {

    @Autowired
    CustomerRepository custRepo;
    @Autowired
    PasswordEncoder encoder;
    // @Autowired
    // Jwts jwtUtils;

    @GetMapping(value = "/test") // flag index to support root
    private String index() {
        return "index of Auth API";
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateCustomer(@Valid @RequestBody LoginRequest loginRequest) {

         Authentication authentication = AuthenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
	}


    @PostMapping("/signup")
	public ResponseEntity<?> registerCustomer(@Valid @RequestBody SignupRequest signUpRequest) {
		if (CustomerRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

    
    /**methods
     * Post method for login 
     * post method for request 
     * 
     * JWT implemenatation and passwordEncoder go into this controller
     */


}
