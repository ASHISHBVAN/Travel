package com.travel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.travel.model.TravelPackage;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {
	
}
