package com.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.model.TypeSalle;

@Repository
public interface TypeSalleRepository extends CrudRepository<TypeSalle, Integer> {

}
