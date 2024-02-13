package com.travel.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travel.Repository.DestinationRepository;
import com.travel.Repository.TravelPackageRepository;
import com.travel.model.Destination;
import com.travel.model.TravelPackage;

@Service
public class DestinationService {
	@Autowired
	private DestinationRepository destinationRepository;

	@Autowired
	private TravelPackageRepository travelPackageRepository;

	@Autowired
	private TravelPackageService travelPackageService;

	// add destination in package
	public Destination addDestination(Destination destination, Long travelPackageId) {
		TravelPackage travelPackage = travelPackageService.getTravelPackageById(travelPackageId);
		destination.setTravelPackage(travelPackage);
		travelPackage.getDestinations().add(destination);
		travelPackageRepository.save(travelPackage);
		return destinationRepository.save(destination);// Return saved destination
	}

}
