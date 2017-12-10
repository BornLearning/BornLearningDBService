package com.cmpe272.gr15.mysql.service;

import com.cmpe272.gr15.mysql.repository.CenterRepository;
import com.cmpe272.gr15.mysql.model.dto.Center;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

/**
 * A class to handle Center queries. Add all specific methods for Centers here. All methods that can be used by other
 * services must be put in DatabaseService class.
 */
@Component
public class CenterService extends DatabaseService<Center,
        com.cmpe272.gr15.mysql.model.Center, CenterRepository> {

    @Autowired
    public CenterService(CenterRepository repository, ModelMapper mapper) {
        super(repository, mapper, Center.class, com.cmpe272.gr15.mysql.model.Center.class);
    }

    public List<Center> getCenterByFacilitatorId(Integer facilitatorId) {
        List<com.cmpe272.gr15.mysql.model.Center> entities = repository.getByFacilitatorId(facilitatorId);
        List<Center> centers = new ArrayList<>();
        if (entities != null && !entities.isEmpty()) {
            entities.forEach(dao -> centers.add(mapper.map(dao, dtoType)));
            return centers;
        }
        return null;
    }

    public List<Center> getCenterByCenterId(Integer centerId) {
        List<com.cmpe272.gr15.mysql.model.Center> entities = repository.getByCenterId(centerId);
        List<Center> centers = new ArrayList<>();
        if (entities != null && !entities.isEmpty()) {
            entities.forEach(dao -> centers.add(mapper.map(dao, dtoType)));
            return centers;
        }
        return null;
    }

    public void deleteCenter(Integer centerId) {
        repository.delete(centerId);
    }

    @Override
    public com.cmpe272.gr15.mysql.model.Center getById(Center dto) {
        return repository.findOne(dto.getCenterId());
    }
}
