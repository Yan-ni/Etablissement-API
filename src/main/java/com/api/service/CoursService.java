package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.Cours;
import com.api.repository.CoursRepository;

@Service
public class CoursService {

  @Autowired
  CoursRepository coursRepository;

  public List<Cours> getAllCours() {
    Iterable<Cours> iterable = coursRepository.findAll();
    List<Cours> result = new ArrayList<Cours>();
    iterable.forEach(result::add);
    return result;
  }

  public Optional<Cours> getCours(String entityId) {
    int id = Integer.parseInt(entityId);
    return coursRepository.findById(id);
  }

  public Cours addCours(Cours cours) {
    return coursRepository.save(cours);
  }

  public Cours updateCours(Cours cours) {
    try {
      return coursRepository.save(cours);
    } catch (Exception e) {
      return new Cours();
    }
  }

  public void deleteCours(String entityId) {
    try {
      int id = Integer.parseInt(entityId);
      coursRepository.deleteById(id);
    } catch (Exception e) {
      return;
    }
  }
}
