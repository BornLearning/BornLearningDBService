package com.cmpe272.gr15.mysql.repository;

import com.cmpe272.gr15.mysql.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Integer>{

}
