package com.cmpe272.gr15.mysql.service;

import com.cmpe272.gr15.mysql.exceptions.InvalidDataException;
import com.cmpe272.gr15.mysql.model.dto.BaseDTO;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for database service. All Services should extend this class.
 *
 * @param <D> Data class from dto package
 * @param <M> Model class from model package
 * @param <R> Repository class from dao package
 */
public abstract class DatabaseService<D extends BaseDTO, M, R extends JpaRepository> {

  private static final Logger LOGGER = Logger.getLogger(DatabaseService.class);

  protected R repository;

  protected ModelMapper mapper;

  protected Class<D> dtoType;

  protected Class<M> daoType;

  public DatabaseService(R repository, ModelMapper mapper, Class dtoType, Class daoType) {
    this.mapper = mapper;
    this.repository = repository;
    this.dtoType = dtoType;
    this.daoType = daoType;
  }

  public List<D> getAll() {
    List<D> dtos = new ArrayList<>();
    repository.findAll().forEach(dao -> dtos.add(mapper.map(dao, dtoType)));
    return dtos;
  }

  public void save(List<D> dtos) {
    dtos.forEach(dto -> save(dto));
  }

  public void save(D dto) {
    M existingEntity = getById(dto);
    if (existingEntity != null) {
      throw new InvalidDataException("Entity already exists!");
    }
    repository.save(mapper.map(dto, daoType));
  }

  public void update(D dto) {
    M existingEntity = getById(dto);
    if (existingEntity == null) {
      throw new InvalidDataException("Entity does not exists!");
    }
    repository.save(mapper.map(dto, daoType));

  }

  public abstract M getById(D dto);

}
