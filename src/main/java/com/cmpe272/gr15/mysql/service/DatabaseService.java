package com.cmpe272.gr15.mysql.service;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for database service. All Services should extend this class.
 *
 * @param <D> Data class from dto package
 * @param <M> Model class from model package
 * @param <R> Repository class from dao package
 */
public abstract class DatabaseService<D, M, R extends JpaRepository> {

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

  public void save(D dto) {
    repository.save(mapper.map(dto, daoType));
  }

}
