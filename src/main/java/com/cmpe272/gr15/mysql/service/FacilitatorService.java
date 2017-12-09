package com.cmpe272.gr15.mysql.service;

import com.cmpe272.gr15.mysql.model.dto.Facilitator;
import com.cmpe272.gr15.mysql.repository.FacilitatorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to handle Center queries. Add all specific methods for Centers here. All methods that can be used by other
 * services must be put in DatabaseService class.
 */
@Component
public class FacilitatorService extends DatabaseService<Facilitator,
        com.cmpe272.gr15.mysql.model.Facilitator, FacilitatorRepository> {

    @Autowired
    public FacilitatorService(FacilitatorRepository repository, ModelMapper mapper) {
        super(repository, mapper, Facilitator.class, com.cmpe272.gr15.mysql.model.Facilitator.class);
    }

    public List<Facilitator> getFacilitatorByFacilitatorId(Integer facilitatorId) {
        List<com.cmpe272.gr15.mysql.model.Facilitator> entities = repository.getByFacilitatorID(facilitatorId);
        List<Facilitator> facilitator = new ArrayList<>();
        if (entities != null && !entities.isEmpty()) {
            return facilitator;
        }
        return null;
    }

    @Override
    public com.cmpe272.gr15.mysql.model.Facilitator getById(Facilitator dto) {
        return repository.findOne(dto.getFacilitatorID());
    }
}
