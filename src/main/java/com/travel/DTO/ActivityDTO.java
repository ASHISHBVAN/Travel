package com.travel.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ActivityDTO {

	private String activityName;

	private String Description;

	private double cost;

	private int capacity;

	public ActivityDTO(String activityName, String description, Long cost, int capacity) {
		super();
		this.activityName = activityName;
		Description = description;
		this.cost = cost;
		this.capacity = capacity;
	}

	public ActivityDTO() {

	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double d) {
		this.cost = d;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
