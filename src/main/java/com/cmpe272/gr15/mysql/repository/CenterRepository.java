package com.cmpe272.gr15.mysql.repository;

import com.cmpe272.gr15.mysql.model.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterRepository extends JpaRepository<Center, Integer> {

    /**
     * Get Centers by Facilitator Id. Spring understands the name of the method and converts it to a SQL query.
     * More example here: https://docs.spring.io/spring-data/jpa/docs/2.0.1.RELEASE/reference/html/
     *
     * @param facilitatorId - Facilitator ID to be used to search for the Center.
     * @return List of Center objects when found.
     */
    List<Center> getByFacilitatorId(Integer facilitatorId);
    List<Center> getByCenterId(Integer centerId);
}