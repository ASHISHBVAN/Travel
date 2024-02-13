package com.travel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.travel.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

	Object findByTravelPackageId(long l);

}
