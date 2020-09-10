/* package com.habibank.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//TODO see if this file is needed and test.
@EnableWebMvc
    @Configuration
	public class MvcConfig extends WebMvcConfigurerAdapter {
	 
	    @Override
	    public void addResourceHandlers(
	      ResourceHandlerRegistry registry) {
	 
            registry.addResourceHandler("/static/**")
	          .addResourceLocations("/src/main/web-app/build/static/");
	        registry.addResourceHandler("/*.js")
	          .addResourceLocations("/src/main/web-app/build/");
	        registry.addResourceHandler("/*.json")
	          .addResourceLocations("/src/main/web-app/build/");
	        registry.addResourceHandler("/*.ico")
	          .addResourceLocations("/src/main/web-app/build/");
	        registry.addResourceHandler("/index.html")
	          .addResourceLocations("/src/main/web-app/build/index.html");
        }
	}	 */