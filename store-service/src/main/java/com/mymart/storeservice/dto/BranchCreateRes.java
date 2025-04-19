package com.mymart.storeservice.dto;

public class BranchCreateRes {

	private Long id;
	private String name;
	private LocationDto location;
	private String contactNumber;
	private String email;
	private String managerName;
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
