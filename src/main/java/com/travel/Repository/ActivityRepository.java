package com.travel.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.travel.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    // Find activities by destination
    List<Activity> findByDestinationId(Long destinationId);

    // Find activities with available capacity
    @Query("SELECT a FROM Activity a WHERE a.capacity > size(a.passengers)")
    List<Activity> findActivitiesWithAvailableCapacity();

 
}
