package com.mymart.storeservice.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	public OpenAPI customOpenAPI() {
		
		return new OpenAPI()
					.info(new Info()
								.title("MyMart Store service APIs")
								.version("1.0")
								.description("API Documentation for MyMart application")
							);
	}
	
}
