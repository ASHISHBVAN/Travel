package com.travel.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Getter
@Setter
@Table
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String passengerNumber;

	@Enumerated(EnumType.STRING)
	private PassengerType type;

	private double balance;

	@ManyToOne
	private TravelPackage travelPackage;

	@ManyToMany(cascade = CascadeType.ALL)
	// @JsonIgnoreProperties("passengers")
	@JoinTable(name = "passenger_activities", joinColumns = @JoinColumn(name = "passengers_id"), inverseJoinColumns = @JoinColumn(name = "activities_id"))
	private List<Activity> activities = new ArrayList<>();

	public Passenger(Long id, String name, String passengerNumber, PassengerType type, double balance,
			TravelPackage travelPackage, List<Activity> activities) {
		super();
		this.id = id;
		this.name = name;
		this.passengerNumber = passengerNumber;
		this.type = type;
		this.balance = balance;
		this.travelPackage = travelPackage;
		this.activities = activities;
	}

	public Passenger() {

	}

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

	public String getPassengerNumber() {
		return passengerNumber;
	}

	public void setPassengerNumber(String passengerNumber) {
		this.passengerNumber = passengerNumber;
	}

	public PassengerType getType() {
		return type;
	}

	public void setType(PassengerType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public TravelPackage getTravelPackage() {
		return travelPackage;
	}

	public void setTravelPackage(TravelPackage travelPackage) {
		this.travelPackage = travelPackage;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + ", passengerNumber=" + passengerNumber + ", type=" + type
				+ ", balance=" + balance + ", travelPackage=" + travelPackage + ", activities=" + activities + "]";
	}

}
