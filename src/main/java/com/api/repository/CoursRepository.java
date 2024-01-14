package com.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.model.Cours;

@Repository
public interface CoursRepository extends CrudRepository<Cours, Integer> {

}
