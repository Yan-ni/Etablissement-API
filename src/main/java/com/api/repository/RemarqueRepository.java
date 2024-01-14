package com.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.model.Remarque;

@Repository
public interface RemarqueRepository extends CrudRepository<Remarque, Integer> {

}
