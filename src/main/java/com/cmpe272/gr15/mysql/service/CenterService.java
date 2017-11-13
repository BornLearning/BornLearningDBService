package com.cmpe272.gr15.mysql.service;

import com.cmpe272.gr15.mysql.repository.CenterRepository;
import com.cmpe272.gr15.mysql.model.dto.Center;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A class to handle Center queries.
 */
@Component
public class CenterService extends DatabaseService<Center,
        com.cmpe272.gr15.mysql.model.Center, CenterRepository> {

    @Autowired
    public CenterService(CenterRepository repository, ModelMapper mapper, Class<Center> dtoType) {
        super(repository, mapper, dtoType);
    }
}
