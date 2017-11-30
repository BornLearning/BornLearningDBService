package com.cmpe272.gr15.mysql.repository;

import com.cmpe272.gr15.mysql.model.Indicator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndicatorRepository extends JpaRepository<Indicator, String>{
    /**
     * Get Indicator by Sub category . Spring understands the name of the method and converts it to a SQL query.
     * More example here: https://docs.spring.io/spring-data/jpa/docs/2.0.1.RELEASE/reference/html/
     *
     * @param subCategory - Facilitator ID to be used to search for the Center.
     * @return List of Center objects when found.
     */
    List<Indicator> getBySubCategory(String subCategory);
}
