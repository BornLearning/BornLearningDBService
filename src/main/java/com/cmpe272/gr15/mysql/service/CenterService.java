package com.cmpe272.gr15.mysql.service;

import com.cmpe272.gr15.mysql.repository.CenterRepository;
import com.cmpe272.gr15.mysql.model.dto.Center;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A class to handle Center queries. Add all specific methods for Centers here. All methods that can be used by other
 * services must be put in DatabaseService class.
 */
@Component
public class CenterService extends DatabaseService<Center,
        com.cmpe272.gr15.mysql.model.Center, CenterRepository> {

    @Autowired
    public CenterService(CenterRepository repository, ModelMapper mapper) {
        super(repository, mapper, Center.class);
    }

    public Center getCenterByFacilitatorId(Integer facilitatorId) {
        com.cmpe272.gr15.mysql.model.Center entity = repository.getByFacilitatorId(facilitatorId);
        return entity != null ? mapper.map(entity, Center.class) : null;
    }
}
