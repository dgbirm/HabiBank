package com.habibank.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.habibank.security.jwt.AuthEntryPointJwt;
import com.habibank.security.jwt.AuthTokenFilter;
import com.habibank.security.services.UserDetailsServiceImpl;

/***
 * 
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
    // securedEnabled = true,
    // jsr250Enabled = true,
    prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



/*   private static final String LOGIN_PROCESSING_URL = "/login";
	private static final String LOGIN_FAILURE_URL = "/login?error";
	private static final String LOGIN_URL = "/login";
  private static final String LOGIN_SUCCESS_URL = "/login";
  

  private static final String SIGNIN_PROCESSING_URL = "/signin";
	private static final String SIGNIN_FAILURE_URL = "/signin?error"; //
	private static final String SIGNIN_URL = "/signin";
  private static final String SIGNIN_SUCCESS_URL = "/login";
   */

  @Autowired
  UserDetailsServiceImpl userDetailsService;
  
  @Autowired
  private AuthEntryPointJwt unauthorizedHandler;

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }


  
  @Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
  }
  





  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

  //

 //For testing 
    auth.inMemoryAuthentication()
    .withUser("cj")
    .password("password")
    .roles("USER");
  }


    @Override
    protected void configure( HttpSecurity http) 
      throws Exception {
        http
        .authorizeRequests()
          .antMatchers("/", "/home","/login", "/signup").permitAll() // (3)
          .anyRequest().authenticated() // (4)
          .and()
       .formLogin() // (5)
         .loginPage("/login") // (5)
         .permitAll()
         .and()
      .logout() // (6)
        .permitAll()
        .and()
      .httpBasic(); // (7)

       /*    .formLogin().loginPage("/index.html")
          .loginProcessingUrl("/perform_login") // Changed to login page 
          .defaultSuccessUrl("/homepage.html",true) //
          .failureUrl("/index.html?error=true"); */
          //...
    }

    @Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers(
        //client side JS and other URIs that should ignore spring security
        "/index.html",
				"/favicon.ico",
				"/robots.txt",
				"/manifest.webmanifest", 
				"/sw.js", 
				"/offline.html", 
				"/icons/**",
				"/images/**",
				"/styles/**",
				"/h2-console/**");
	}
    
}