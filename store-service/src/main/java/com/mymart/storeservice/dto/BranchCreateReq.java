package com.mymart.storeservice.dto;

public class BranchCreateReq {

	private String name;
	private LocationDto location;
	private String contactNumber;
	private String email;
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
