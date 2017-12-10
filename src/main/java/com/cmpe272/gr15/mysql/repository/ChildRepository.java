package com.cmpe272.gr15.mysql.repository;

import com.cmpe272.gr15.mysql.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child,Integer> {

    //@Query(value = "SELECT c FROM Child c where c.active='Y'")
    //@Query(value = "FROM Child c WHERE c.active = 'Y'")
    List<Child> getByCenterID(Integer centerID);

    Child getByChildID(Integer childID);
}
