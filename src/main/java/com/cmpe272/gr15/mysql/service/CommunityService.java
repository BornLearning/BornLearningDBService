package com.cmpe272.gr15.mysql.service;

import com.cmpe272.gr15.mysql.model.dto.Community;
import com.cmpe272.gr15.mysql.repository.CommunityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommunityService extends DatabaseService<Community,
        com.cmpe272.gr15.mysql.model.Community, CommunityRepository>{

    @Autowired
    public CommunityService(CommunityRepository repository, ModelMapper mapper) {
        super(repository, mapper, Community.class, com.cmpe272.gr15.mysql.model.Community.class);
    }

    /**
     * @param dto
     * @return
     */
    @Override
    public com.cmpe272.gr15.mysql.model.Community getById(Community dto) {
        return null;
    }

}
