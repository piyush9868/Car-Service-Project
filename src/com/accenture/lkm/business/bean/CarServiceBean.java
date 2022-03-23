package com.accenture.lkm.business.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class CarServiceBean {
	
	private static Integer serviceId = 0;
	private String carType;
	
	@NotEmpty(message = "Car number is mandatory")
	private String carNumber;
	
	@NotNull(message = "Please select the Parts")
	private Integer partId;
	
	@Size(min = 5,max = 10 , message = "Username should be between 5 and 10 characters")
	private String username;
	private Integer totalRepairCost;
	
//	private PartsBean part;
	
	public CarServiceBean() {
		serviceId++;
	}
	
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getTotalRepairCost() {
		return totalRepairCost;
	}
	public void setTotalRepairCost(Integer totalRepairCost) {
		this.totalRepairCost = totalRepairCost;
	}
//	public PartsBean getPart() {
//		return part;
//	}
//	public void setPart(PartsBean part) {
//		this.part = part;
//	}
	
	
	
	
}
