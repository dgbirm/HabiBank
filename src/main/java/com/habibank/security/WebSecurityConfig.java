package com.habibank.security;

import com.habibank.security.jwt.AuthEntryPointJwt;
import com.habibank.security.jwt.AuthTokenFilter;
import com.habibank.security.services.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/***
 * 
 */
@Configuration
@EnableWebMvc
@EnableWebSecurity
@EnableGlobalMethodSecurity(
    // securedEnabled = true,
    // jsr250Enabled = true,
    prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


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

/*  //For testing 
    auth.inMemoryAuthentication()
    .withUser("cj")
    .password("password")
    .roles("USER"); */
  }

  


    @Override
    protected void configure( HttpSecurity http) 
      throws Exception {
        http.csrf().disable()
        .authorizeRequests().antMatchers(HttpMethod.OPTIONS,"*/").permitAll()
        .antMatchers(HttpMethod.GET,"/login").permitAll();

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
        "/auth/**",
        "/api/**",
				"/h2-console/**");
	}
    
}