package com.travel.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class TravelPackage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String travelPackageName;

	private int passengerCapacity;

	@OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL)
	// @JsonIgnoreProperties("TravelPackage")
	private List<Destination> destinations = new ArrayList<>();

	@OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL)
	// @JsonIgnoreProperties("travelPackage")
	private List<Passenger> passengers = new ArrayList<>();

	public TravelPackage() {

	}

	public TravelPackage(Long id, String name, int passengerCapacity, List<Destination> destinations,
			List<Passenger> passengers) {
		super();
		this.id = id;
		this.travelPackageName = name;
		this.passengerCapacity = passengerCapacity;
		this.destinations = destinations;
		this.passengers = passengers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return travelPackageName;
	}

	public void setName(String name) {
		this.travelPackageName = name;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "TravelPackage [id=" + id + ", name=" + travelPackageName + ", passengerCapacity=" + passengerCapacity
				+ ", destinations=" + destinations + ", passengers=" + passengers + "]";
	}

}
