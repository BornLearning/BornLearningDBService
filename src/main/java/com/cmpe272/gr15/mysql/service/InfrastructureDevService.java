package com.cmpe272.gr15.mysql.service;

import com.cmpe272.gr15.mysql.model.InfrastructureDev;
import com.cmpe272.gr15.mysql.repository.IndicatorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InfrastructureDevService extends DatabaseService<InfrastructureDev,
        com.cmpe272.gr15.mysql.model.Indicator, IndicatorRepository> {

    @Autowired
    public InfrastructureDevService(IndicatorRepository repository, ModelMapper mapper) {
        super(repository, mapper, InfrastructureDev.class, com.cmpe272.gr15.mysql.model.InfrastructureDev.class);
    }
}