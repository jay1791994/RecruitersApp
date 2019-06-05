package com.jay.app;

import javax.activation.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class UserAppConfig extends WebMvcConfigurationSupport  {
 
	@Override
	protected void	addCorsMappings(CorsRegistry registry) {
	   
		registry.addMapping("/**")
		.allowedMethods("*")
		.allowedOrigins("*");
        
	}

}

