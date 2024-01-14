package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.Remarque;
import com.api.repository.RemarqueRepository;

@Service
public class RemarqueService {

  @Autowired
  RemarqueRepository remarqueRepository;

  public List<Remarque> getAllRemarque() {
    Iterable<Remarque> iterable = remarqueRepository.findAll();
    List<Remarque> result = new ArrayList<Remarque>();
    iterable.forEach(result::add);
    return result;
  }

  public Optional<Remarque> getRemarque(String entityId) {
    int id = Integer.parseInt(entityId);
    return remarqueRepository.findById(id);
  }

  public Remarque addRemarque(Remarque remarque) {
    return remarqueRepository.save(remarque);
  }

  public Remarque updateRemarque(Remarque remarque) {
    try {
      return remarqueRepository.save(remarque);
    } catch (Exception e) {
      return new Remarque();
    }
  }

  public void deleteRemarque(String entityId) {
    try {
      int id = Integer.parseInt(entityId);
      remarqueRepository.deleteById(id);
    } catch (Exception e) {
      return;
    }
  }
}
