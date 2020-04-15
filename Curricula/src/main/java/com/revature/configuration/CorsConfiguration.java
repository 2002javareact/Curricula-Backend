package com.revature.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer{

	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/**") // all endpoints in the api
        .allowedOrigins("http://localhost:1234", "http://localhost:3000","http://localhost:2020","http://project1-cabrerojesus.s3-website.us-east-2.amazonaws.com/") // allow this origin
        .allowedMethods("PUT", "DELETE", "GET", "OPTIONS", "POST", "PATCH")
        .allowedHeaders("header1", "Content-Type", "Authorization")
//        .exposedHeaders("header1", "header2")
        .allowCredentials(true);
	}
	
}
