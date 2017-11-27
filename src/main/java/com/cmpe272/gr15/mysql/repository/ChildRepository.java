package com.cmpe272.gr15.mysql.repository;

import com.cmpe272.gr15.mysql.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child,Integer> {

    List<Child> getByCenterID(Integer centerID);
    Child getChildInfoByChildID(Integer childID);
}
