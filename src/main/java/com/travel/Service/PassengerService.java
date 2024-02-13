package com.travel.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travel.DTO.ActivityDTO;
import com.travel.DTO.PassengerDTO;
import com.travel.DTO.PassengerDetailsDTO;
import com.travel.DTO.PassengerListDTO;
import com.travel.Repository.PassengerRepository;
import com.travel.Repository.TravelPackageRepository;
import com.travel.model.Passenger;
import com.travel.model.TravelPackage;

@Service
public class PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private TravelPackageRepository travelPackageRepository;

	// Passenger List with travel package
	public PassengerListDTO getPassengerListAndTravelPackage(Long travelPackageId) {
		Optional<TravelPackage> optionalTravelPackage = travelPackageRepository.findById(travelPackageId);
		if (optionalTravelPackage.isEmpty()) {
			return null;
		}

		TravelPackage travelPackage = optionalTravelPackage.get();
		PassengerListDTO passengerListDTO = new PassengerListDTO();
		passengerListDTO.setPackageName(travelPackage.getName());
		passengerListDTO.setPassengerCapacity(travelPackage.getPassengerCapacity());

		List<Passenger> passengers = travelPackage.getPassengers();
		int numPassengers = passengers.size();
		passengerListDTO.setNumPassengers(numPassengers);

		List<PassengerDTO> passengerDTOs = passengers.stream().map(passenger -> {
			PassengerDTO passengerDTO = new PassengerDTO();
			passengerDTO.setName(passenger.getName());
			passengerDTO.setNumber(passenger.getPassengerNumber());
			return passengerDTO;
		}).collect(Collectors.toList());

		passengerListDTO.setPassengers(passengerDTOs);

		return passengerListDTO;
	}

	// specific passenger detail
	public PassengerDetailsDTO getPassengerDetails(Long passengerId) {
		Optional<Passenger> optionalPassenger = passengerRepository.findById(passengerId);
		if (optionalPassenger.isEmpty()) {
			return null; // Or throw an exception
		}

		Passenger passenger = optionalPassenger.get();
		PassengerDetailsDTO passengerDetailsDTO = new PassengerDetailsDTO();
		passengerDetailsDTO.setName(passenger.getName());
		passengerDetailsDTO.setPassengerNumber(passenger.getPassengerNumber());
		passengerDetailsDTO.setBalance(passenger.getBalance());

		System.out.println(" activity " + passenger.getActivities());
		List<ActivityDTO> activityDTOs = passenger.getActivities().stream().map(activity -> {
			ActivityDTO activityDTO = new ActivityDTO();
			activityDTO.setActivityName((activity.getName()));
			activityDTO.setDescription(activity.getDescription());
			activityDTO.setCost(activity.getCost());
			activityDTO.setCapacity(activity.getCapacity());

			return activityDTO;
		}).collect(Collectors.toList());

		passengerDetailsDTO.setActivities(activityDTOs);

		return passengerDetailsDTO;
	}

	
    // save passenger
	public Passenger savePassenger(Passenger passenger) {
	
		passenger = passengerRepository.save(passenger);

		return passenger;
	}

}
