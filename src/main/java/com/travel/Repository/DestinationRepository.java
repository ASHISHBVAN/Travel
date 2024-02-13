package com.travel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.travel.model.Destination;

@Repository
public interface DestinationRepository  extends JpaRepository<Destination, Long>{
		

}
