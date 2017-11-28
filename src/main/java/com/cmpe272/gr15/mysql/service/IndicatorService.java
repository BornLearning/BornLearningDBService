package com.cmpe272.gr15.mysql.service;

import com.cmpe272.gr15.mysql.repository.IndicatorRepository;
import com.cmpe272.gr15.mysql.model.Indicator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to handle Indicator queries.
 */
@Component
public class IndicatorService extends DatabaseService<Indicator,
        com.cmpe272.gr15.mysql.model.Indicator, IndicatorRepository>{


    @Autowired
    public IndicatorService(IndicatorRepository repository, ModelMapper mapper) {
        super(repository, mapper, Indicator.class, com.cmpe272.gr15.mysql.model.Indicator.class);
    }

    public List<Indicator> getIndicatorBySubCategory(String subCategory, Integer ageGroup) {
        List<com.cmpe272.gr15.mysql.model.Indicator> entities = repository.getBySubCategory(subCategory);
        Integer childAge = ageGroup;

        System.out.println("age is" + childAge);
        List<Indicator> indicators = new ArrayList<>();
        List<Indicator> indicatorsByAge = new ArrayList<>();

        if (entities != null && !entities.isEmpty()) {

            entities.forEach(dao -> indicators.add(mapper.map(dao, dtoType)));

            for(Indicator i : indicators){
                if(childAge.equals(0)){
                    indicatorsByAge.add(i);
                } else{
                    String ageRange = i.getAgeGroup();
                    String[] age = ageRange.split("-");
                    if(childAge.equals(Integer.parseInt(age[0].trim())) || childAge.equals(Integer.parseInt(age[1].trim()))){
                        indicatorsByAge.add(i);
                    }
                }
            }
            if(indicatorsByAge.isEmpty()){
                return null;
            } else {
                return indicatorsByAge;
            }
        }
        return null;
    }
}
