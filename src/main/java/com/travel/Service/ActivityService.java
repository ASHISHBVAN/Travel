package com.travel.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travel.Repository.ActivityRepository;
import com.travel.Repository.DestinationRepository;
import com.travel.Repository.PassengerRepository;
import com.travel.model.Activity;
import com.travel.model.Destination;
import com.travel.model.Passenger;


@Service
public class ActivityService {

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private DestinationRepository destinationRepository;

	@Autowired
	private PassengerRepository passengerRepository;
	
	// find activities with available capacity
	public List<Activity> getActivitiesWithAvailableSpaces() {
		// Fetch all activities from the database
		List<Activity> allActivities = activityRepository.findAll();
		
		// Filter activities with available spaces
		List<Activity> activitiesWithAvailableSpaces = allActivities.stream()
				.filter(activity -> activity.getCapacity() > activity.getPassengers().size())
				.collect(Collectors.toList());

		return activitiesWithAvailableSpaces;
	}

	public String signUpForActivity(Long passengerId, Long activityId) {
		
		Passenger passenger = passengerRepository.findById(passengerId)
				.orElseThrow(() -> new IllegalArgumentException("Passenger not found with id: " + passengerId));
		Activity activity = activityRepository.findById(activityId)
				.orElseThrow(() -> new IllegalArgumentException("Activity not found with id: " + activityId));

		switch (passenger.getType()) {
		case STANDARD:
			signUpStandardPassenger(passenger, activity);
			break;
		case GOLD:
			signUpGoldPassenger(passenger, activity);
			break;
		case PREMIUM:
			signUpPremiumPassenger(passenger, activity);
			break;
		default:
			throw new IllegalArgumentException("Invalid passenger type");
		}

		return "activity added";
	}

	// for standard passenger
	private void signUpStandardPassenger(Passenger passenger, Activity activity) {
		
		double cost = activity.getCost();
		if (passenger.getBalance() >= cost) {
			deductBalance(passenger, cost);
			signUpPassengerForActivity(passenger, activity);
		} else {
			throw new IllegalStateException("Insufficient balance");
		}
		
	}

	// for gold passenger
	private void signUpGoldPassenger(Passenger passenger, Activity activity) {
		
		double cost = activity.getCost() * 0.9; // Apply 10% discount
		if (passenger.getBalance() >= cost) {
			deductBalance(passenger, cost);
			signUpPassengerForActivity(passenger, activity);
		} else {
			throw new IllegalStateException("Insufficient balance");
		}

		

	}

	// for premium passenger
	private void signUpPremiumPassenger(Passenger passenger, Activity activity) {
	
		// Premium passengers can sign up for activities for free
		signUpPassengerForActivity(passenger, activity);

	}

	// balancing
	private void deductBalance(Passenger passenger, double amount) {
		
		double newBalance = passenger.getBalance() - amount;
		passenger.setBalance(newBalance);
		passengerRepository.save(passenger);

	}

	// register passenger for activity
	private void signUpPassengerForActivity(Passenger passenger, Activity activity) {
		
		List<Activity> activities = passenger.getActivities();
		
		activities.add(activity);
		
		passenger.setActivities(activities);
	
		passengerRepository.save(passenger);
		
		activity.setCapacity(activity.getCapacity()-1);
		
		activityRepository.save(activity);
        
	}

	// create activity
	public Activity createActivity(Activity activity, Long destinationId) throws Exception {
		Optional<Destination> destination = destinationRepository.findById(destinationId);
		if (!destination.isPresent()) {
			throw new Exception("Destination not found with id: " + destinationId);
		}
		activity.setDestination(destination.get());
		return activityRepository.save(activity);

	}

}
