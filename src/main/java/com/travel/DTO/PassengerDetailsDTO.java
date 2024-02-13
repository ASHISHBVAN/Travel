package com.travel.DTO;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PassengerDetailsDTO {

	private String name;
	private String passengerNumber;
	private double balance;
	private List<ActivityDTO> activities;

	public PassengerDetailsDTO(String name, String passengerNumber, double balance, List<ActivityDTO> activities) {
		super();
		this.name = name;
		this.passengerNumber = passengerNumber;
		this.balance = balance;
		this.activities = activities;
	}

	public PassengerDetailsDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassengerNumber() {
		return passengerNumber;
	}

	public void setPassengerNumber(String passengerNumber) {
		this.passengerNumber = passengerNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<ActivityDTO> getActivities() {
		return activities;
	}

	public void setActivities(List<ActivityDTO> activities) {
		this.activities = activities;
	}

}
