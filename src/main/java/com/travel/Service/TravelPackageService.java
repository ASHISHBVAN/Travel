package com.travel.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travel.DTO.ActivityDTO;
import com.travel.DTO.DestinationDTO;
import com.travel.DTO.ItineraryDTO;
import com.travel.Repository.TravelPackageRepository;
import com.travel.model.Activity;
import com.travel.model.Destination;
import com.travel.model.TravelPackage;

@Service
public class TravelPackageService {

	@Autowired
	private TravelPackageRepository travelPackageRepository;

	public TravelPackageService(TravelPackageRepository travelPackageRepository2) {
		// TODO Auto-generated constructor stub
	}

	// create package
	public TravelPackage createTravelPackage(TravelPackage travelPackage) {

		return travelPackageRepository.save(travelPackage);
	}

	// get specific package
	public TravelPackage getTravelPackageById(Long id) {
		return travelPackageRepository.findById(id).orElseThrow();
	}

	// print Itinerary
	public ItineraryDTO printItinerary(Long travelPackageId) {
		Optional<TravelPackage> optionalTravelPackage = travelPackageRepository.findById(travelPackageId);
		if (optionalTravelPackage.isEmpty()) {
			return null;
		}

		TravelPackage travelPackage = optionalTravelPackage.get();
		ItineraryDTO itineraryDTO = new ItineraryDTO();

		itineraryDTO.setTravelPackageName(travelPackage.getName());

		List<DestinationDTO> destinationDTOList = new ArrayList<>();

		for (Destination destination : travelPackage.getDestinations()) {

			DestinationDTO destinationDTO = new DestinationDTO();

			destinationDTO.setDestinationName(destination.getName());

			List<ActivityDTO> activityDTOList = new ArrayList<>();

			for (Activity activity : destination.getActivities()) {

				ActivityDTO activityDTO = new ActivityDTO();
				activityDTO.setActivityName(activity.getName());
				activityDTO.setDescription(activity.getDescription());
				activityDTO.setCost(activity.getCost());
				activityDTO.setCapacity(activity.getCapacity());
				activityDTOList.add(activityDTO);
			}

			destinationDTO.setActivities(activityDTOList);
			destinationDTOList.add(destinationDTO);
		}

		itineraryDTO.setDestinations(destinationDTOList);
		return itineraryDTO;
	}
}
