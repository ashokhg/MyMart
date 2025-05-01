package com.mymart.userservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Request payload for role creation")
public class RoleCreateDto {

	@Schema(
	        description  = "Rranch name",
	        example       = "MADMIN",
	        requiredMode  = Schema.RequiredMode.REQUIRED
	    )
	@NotBlank(message = "Name is required")
	String name;
	
	@Schema(
	        description  = "Rranch name",
	        example       = "MADMIN",
	        requiredMode  = Schema.RequiredMode.REQUIRED
	    )
	@NotBlank(message = "Name is required")
	String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "RoleCreateRequest [name=" + name + ", description=" + description + "]";
	}
}
