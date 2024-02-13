package com.travel.DTO;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PassengerListDTO {

	private String packageName;
	private int passengerCapacity;
	private int numPassengers;
	private List<PassengerDTO> passengers;

	public PassengerListDTO(String packageName, int passengerCapacity, int numPassengers,
			List<PassengerDTO> passengers) {
		super();
		this.packageName = packageName;
		this.passengerCapacity = passengerCapacity;
		this.numPassengers = numPassengers;
		this.passengers = passengers;
	}

	public PassengerListDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public int getNumPassengers() {
		return numPassengers;
	}

	public void setNumPassengers(int numPassengers) {
		this.numPassengers = numPassengers;
	}

	public List<PassengerDTO> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<PassengerDTO> passengers) {
		this.passengers = passengers;
	}

}
