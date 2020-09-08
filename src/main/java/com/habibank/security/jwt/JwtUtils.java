package com.habibank.security.jwt;

import java.util.Date;

import com.habibank.security.services.UserDetailsImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
/***
 * Utility class for generating, parsing, and Validating JWT tokens
 * 
 * References
 * https://openid.net/specs/draft-jones-json-web-signature-04.html
 * https://tools.ietf.org/html/draft-ietf-oauth-json-web-token-25#section-4.1.2
 */
@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	
	@Value("${habibank.app.jwtSecret}")
	private String jwtSecret;
	@Value("${habibank.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	/***
	 * Method for generating and building a JWT token based on a user's username  
	 * @param auth  an authentication request object after the request has been processed by the AuthenticationManager.authenticate(Authentication) method.
	 * @return a new JwtBuilder instance -> a JWT compact serialized string with username, dates for token
	 */
	public String generateJwtToken(Authentication auth) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) auth.getPrincipal();
		
		return Jwts.builder()
		.setSubject((userPrincipal.getUsername()))
		.setIssuedAt(new Date())
		.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)) 
		.signWith(SignatureAlgorithm.HS512, jwtSecret)   //Sign with SHA512 hashing algorithm with secret key and makes it a JSON Web Signature
		.compact();
	}
	/***
	 * Method for getting the 
	 * @param token
	 * @return
	 */
	public String getUserNameFromJwtToken(String token){
		return Jwts.parser()
		.setSigningKey(jwtSecret)
		.parseClaimsJws(token)
		.getBody()
		.getSubject();
	}

	//TODO
	public boolean validateJwtToken(String jwt) {
		return null;
	}


    /**
     * @return String return the jwtSecret
     */
    public String getJwtSecret() {
        return jwtSecret;
    }

    /**
     * @param jwtSecret the jwtSecret to set
     */
    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    /**
     * @return int return the jwtExpirationMs
     */
    public int getJwtExpirationMs() {
        return jwtExpirationMs;
    }

    /**
     * @param jwtExpirationMs the jwtExpirationMs to set
     */
    public void setJwtExpirationMs(int jwtExpirationMs) {
        this.jwtExpirationMs = jwtExpirationMs;
    }

}
