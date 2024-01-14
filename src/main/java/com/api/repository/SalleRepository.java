package com.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.model.Salle;

@Repository
public interface SalleRepository extends CrudRepository<Salle, Integer> {

}
