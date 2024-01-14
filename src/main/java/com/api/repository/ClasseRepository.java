package com.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.model.Classe;

@Repository
public interface ClasseRepository extends CrudRepository<Classe, Integer> {
}