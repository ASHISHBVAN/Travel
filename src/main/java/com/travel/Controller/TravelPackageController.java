package com.travel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.travel.DTO.ItineraryDTO;
import com.travel.DTO.PassengerDetailsDTO;
import com.travel.DTO.PassengerListDTO;
import com.travel.Service.ActivityService;
import com.travel.Service.DestinationService;
import com.travel.Service.PassengerService;
import com.travel.Service.TravelPackageService;
import com.travel.model.Activity;
import com.travel.model.Destination;
import com.travel.model.Passenger;
import com.travel.model.TravelPackage;

@RestController
@RequestMapping("/travel")
public class TravelPackageController {

	@Autowired
	private PassengerService passengerService;

	@Autowired
	private TravelPackageService travelPackageService;

	@Autowired
	private DestinationService destinationService;

	@Autowired
	private ActivityService activityService;

	@PostMapping("/create/passanger")
	public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {

		Passenger savedPassenger = passengerService.savePassenger(passenger);

		return ResponseEntity.ok(savedPassenger);
	}

	@PostMapping("/create/travelpackage")
	public ResponseEntity<TravelPackage> createTravelPackage(@RequestBody TravelPackage travelPackage) {

		TravelPackage savedPackage = travelPackageService.createTravelPackage(travelPackage);

		return ResponseEntity.ok(savedPackage);
	}

	@PostMapping("/add/destination/{packageId}")
	public ResponseEntity<Destination> addDestination(@PathVariable Long packageId,
			@RequestBody Destination destination) {

		Destination savedDestination = destinationService.addDestination(destination, packageId);

		return ResponseEntity.ok(savedDestination);
	}

	@PostMapping("/create/activity/{destinationId}")
	public ResponseEntity<Activity> createActivity(@PathVariable Long destinationId, @RequestBody Activity activity)
			throws Exception {

		Activity savedActivity = activityService.createActivity(activity, destinationId);

		return ResponseEntity.ok(savedActivity);
	}

	@GetMapping("/passangerwithtravel/{id}")
	public ResponseEntity<PassengerListDTO> getPassangerList(@PathVariable Long id) {

		PassengerListDTO passangers = passengerService.getPassengerListAndTravelPackage(id);

		return ResponseEntity.ok(passangers);
	}

	@GetMapping("/{id}/itinerary")
	public ResponseEntity<ItineraryDTO> getTravelPackages(@PathVariable Long id) {

		ItineraryDTO listOfPackage = travelPackageService.printItinerary(id);

		System.out.println(" IM In createTravelPackage " + listOfPackage);

		return ResponseEntity.ok(listOfPackage);
	}

	@GetMapping("/available/activities")
	public ResponseEntity<List<Activity>> getActivityAvailable() {

		return ResponseEntity.ok(activityService.getActivitiesWithAvailableSpaces());
	}

	@PostMapping("/add/activity/{passangerId}/{activityId}")
	public String addActivity(@PathVariable Long activityId, @PathVariable Long passangerId) {

		return activityService.signUpForActivity(passangerId, activityId);

	}

	@GetMapping("/passangers/details/{id}")
	public ResponseEntity<PassengerDetailsDTO> getPassangerDetails(@PathVariable Long id) {

		PassengerDetailsDTO passangers = passengerService.getPassengerDetails(id);

		return ResponseEntity.ok(passangers);
	}

}
