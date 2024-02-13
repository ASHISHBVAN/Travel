package com.travel.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PassengerDTO {

	private String name;
	private String number;

	public PassengerDTO(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}

	public PassengerDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
