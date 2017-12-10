package com.cmpe272.gr15.mysql.service;

import com.cmpe272.gr15.mysql.model.dto.Child;
import com.cmpe272.gr15.mysql.repository.ChildRepository;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ChildService extends DatabaseService<Child,
        com.cmpe272.gr15.mysql.model.Child, ChildRepository> {

    private static final Logger LOGGER = Logger.getLogger(ChildService.class);


    @Autowired
    public ChildService(ChildRepository repository, ModelMapper mapper) {
        super(repository, mapper, Child.class, com.cmpe272.gr15.mysql.model.Child.class);
    }
    public List<Child> getChildByCenterID(Integer centerID) {
        List<com.cmpe272.gr15.mysql.model.Child> entities = repository.getByCenterID(centerID);
        List<Child> children = new ArrayList<>();
        if (entities != null && !entities.isEmpty()) {
            entities.forEach(dao -> children.add(mapper.map(dao, dtoType)));
            children.forEach(child -> {
                try {
                    addAge(child);
                } catch (ParseException errParse) {
                    LOGGER.error("Error parsing child: " + errParse.getMessage());
                }
            });
            return children;
        }
        return null;
    }

    public void addAge(Child child) throws ParseException {
        Date d1 = new Date();
        System.out.println(d1);
        Date d2 = new SimpleDateFormat("dd/MM/yyyy").parse(child.getChildDOB());
        long diff = Math.abs(d1.getTime() - d2.getTime());
        long diffDays = diff / (24 * 60 * 60 * 1000);
        int age = Integer.parseInt(""+(diffDays/365));
        System.out.println(d2);
        child.setAge(age);
    }

    public Child getChildInfoByChildID(Integer childID) throws ParseException {
        com.cmpe272.gr15.mysql.model.Child entity = repository.getByChildID(childID);
        if (entity == null) {
            return null;
        }
        Child child = mapper.map(entity, dtoType);
        addAge(child);
        return child;
    }

    @Override
    public com.cmpe272.gr15.mysql.model.Child getById(Child dto) {
        return repository.findOne(dto.getChildID());
    }
}
