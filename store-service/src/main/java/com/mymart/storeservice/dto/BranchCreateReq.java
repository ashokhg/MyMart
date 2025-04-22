package com.mymart.storeservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BranchCreateReq {

	@NotBlank(message = "Name is required")
	private String name;
	
	@NotNull
	private LocationDto location;
	
	@Size(min = 10, message = "Contacter number size should be min 10")
	private String contactNumber;
	
	@Email(message = "Invalid email format")
	private String email;
	
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
