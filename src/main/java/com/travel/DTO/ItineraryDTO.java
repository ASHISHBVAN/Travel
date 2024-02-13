package com.travel.DTO;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ItineraryDTO {

	private String travelPackageName;

	private List<DestinationDTO> destinations = new ArrayList<DestinationDTO>();

	public ItineraryDTO(String travelPackageName, List<DestinationDTO> destinations) {
		super();
		this.travelPackageName = travelPackageName;
		this.destinations = destinations;
	}

	public ItineraryDTO() {

	}

	public String getTravelPackageName() {
		return travelPackageName;
	}

	public void setTravelPackageName(String travelPackageName) {
		this.travelPackageName = travelPackageName;
	}

	public List<DestinationDTO> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<DestinationDTO> destinations) {
		this.destinations = destinations;
	}

}
