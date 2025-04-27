package com.mymart.storeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response returned after a branch is created/ updated")
public class BranchCreateRes {

	@Schema( description = "System generated unique identifier", example = "52")
	private Long id;
	
	@Schema( description = "Created branch name")
	private String name;
	
	@Schema( description = "Created branch location")
	private LocationDto location;
	
	@Schema( description = "Created branch contact number")
	private String contactNumber;
	
	@Schema( description = "Created branch manager's email")
	private String email;
	
	@Schema( description = "Created branch manager's name")
	private String managerName;
	
	@Schema( description = "Created branch active status")
	private boolean isActive;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "BranchResponseDto [id=" + id + ", name=" + name + ", location=" + location + ", contactNumber="
				+ contactNumber + ", email=" + email + ", managerName=" + managerName + ", isActive=" + isActive + "]";
	}
}
