package com.cmpe272.gr15.mysql.service;

import com.cmpe272.gr15.mysql.model.Indicator;
import com.cmpe272.gr15.mysql.model.dto.InfrastructureDev;
import com.cmpe272.gr15.mysql.repository.InfrastructureDevRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class InfrastructureDevService extends DatabaseService<InfrastructureDev,
        com.cmpe272.gr15.mysql.model.InfrastructureDev, InfrastructureDevRepository> {

    @Autowired
    public InfrastructureDevService(InfrastructureDevRepository repository, ModelMapper mapper) {
        super(repository, mapper, InfrastructureDev.class, com.cmpe272.gr15.mysql.model.InfrastructureDev.class);
    }

    /**
     * @param dto
     * @return
     */
//    @Override
//    public com.cmpe272.gr15.mysql.model.InfrastructureDev getById(InfrastructureDev dto) {
//        return null;
//    }


    @Override
    public com.cmpe272.gr15.mysql.model.InfrastructureDev getById(InfrastructureDev dto) {
        return null;
    }
}