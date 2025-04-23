package com.mymart.storeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Request payload for creating a new branch")
public class BranchCreateReq {

	@Schema(
	        description  = "Human‑readable branch name",
	        example       = "Mumbai‑Andheri",
	        requiredMode  = Schema.RequiredMode.REQUIRED
	    )
	@NotBlank(message = "Name is required")
	private String name;
	
	@Schema(description = "Location details" )
	@NotNull
	private LocationDto location;
	
	@Schema(description = "Contact number, shoul be size 10",example = "7876659887")
	@Size(min = 10, message = "Contacter number size should be min 10")
	private String contactNumber;
	
	@Schema(description = "Manager's email", example = "email@mymart.com")
	@Email(message = "Invalid email format")
	private String email;
	
	@Schema(  description = "Manager name",example = "Ashok" )
	@NotBlank
	private String managerName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocationDto getLocation() {
		return location;
	}
	public void setLocation(LocationDto location) {
		this.location = location;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	@Override
	public String toString() {
		return "Branch [name=" + name + ", location=" + location + ", contactNumber=" + contactNumber + ", email="
				+ email + ", managerName=" + managerName + "]";
	}
	
}
