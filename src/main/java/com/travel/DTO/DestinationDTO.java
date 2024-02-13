package com.travel.DTO;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class DestinationDTO {

	private String destinationName;

	private List<ActivityDTO> activities = new ArrayList<>();

	public DestinationDTO(String destinationName, List<ActivityDTO> activities) {
		super();
		this.destinationName = destinationName;
		this.activities = activities;
	}

	public DestinationDTO() {

	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public List<ActivityDTO> getActivities() {
		return activities;
	}

	public void setActivities(List<ActivityDTO> activities) {
		this.activities = activities;
	}

}
