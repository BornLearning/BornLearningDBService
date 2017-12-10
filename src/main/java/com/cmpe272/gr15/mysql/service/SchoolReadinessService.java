package com.cmpe272.gr15.mysql.service;

import com.cmpe272.gr15.mysql.model.dto.SchoolReadiness;
import com.cmpe272.gr15.mysql.repository.SchoolReadinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Component;

@Component
public class SchoolReadinessService extends DatabaseService<SchoolReadiness,
        com.cmpe272.gr15.mysql.model.SchoolReadiness, SchoolReadinessRepository> {

    @Autowired
    public SchoolReadinessService(SchoolReadinessRepository repository, ModelMapper mapper) {
        super(repository, mapper, SchoolReadiness.class, com.cmpe272.gr15.mysql.model.SchoolReadiness.class);
    }

    /**
     * @param dto
     * @return
     */
    @Override
    public com.cmpe272.gr15.mysql.model.SchoolReadiness getById(SchoolReadiness dto) {
        return null;
    }
}