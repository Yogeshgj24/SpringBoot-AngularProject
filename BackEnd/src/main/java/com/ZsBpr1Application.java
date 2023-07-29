package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ZsBpr1Application {

	public static void main(String[] args) {
		SpringApplication.run(ZsBpr1Application.class, args);
	}
	/*
	 @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                        .allowedOrigins("http://localhost:4200") // Add your frontend's origin here
	                        .allowedMethods("GET", "POST", "PUT", "DELETE")
	                        .allowedHeaders("*")
	                        .allowCredentials(true);
	            }
	        };
	    }
	 		*/
}
