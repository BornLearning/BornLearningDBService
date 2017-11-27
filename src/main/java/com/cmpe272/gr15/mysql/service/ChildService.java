package com.cmpe272.gr15.mysql.service;

import com.cmpe272.gr15.mysql.model.Child;
import com.cmpe272.gr15.mysql.model.dto.Center;
import com.cmpe272.gr15.mysql.repository.CenterRepository;
import com.cmpe272.gr15.mysql.repository.ChildRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChildService extends DatabaseService<Child,
        com.cmpe272.gr15.mysql.model.Child, ChildRepository> {

    @Autowired
    public ChildService(ChildRepository repository, ModelMapper mapper) {
        super(repository, mapper, Child.class, com.cmpe272.gr15.mysql.model.Child.class);
    }
    public List<Child> getChildByCenterID(Integer centerID) {
        List<com.cmpe272.gr15.mysql.model.Child> entities = repository.getByCenterID(centerID);
        List<Child> children = new ArrayList<>();
        if (entities != null && !entities.isEmpty()) {
            entities.forEach(dao -> children.add(mapper.map(dao, dtoType)));
            return children;
        }
        return null;
    }

    public Child getChildInfoByChildID(Integer childID) {
        Child entity = repository.getChildInfoByChildID(childID);
        return entity;
    }
}
