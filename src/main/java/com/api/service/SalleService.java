package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.Salle;
import com.api.repository.SalleRepository;

@Service
public class SalleService {

  @Autowired
  SalleRepository salleRepository;

  public List<Salle> getAllSalle() {
    Iterable<Salle> iterable = salleRepository.findAll();
    List<Salle> result = new ArrayList<Salle>();
    iterable.forEach(result::add);
    return result;
  }

  public Optional<Salle> getSalle(String entityId) {
    int id = Integer.parseInt(entityId);
    return salleRepository.findById(id);
  }

  public Salle addSalle(Salle salle) {
    return salleRepository.save(salle);
  }

  public Salle updateSalle(Salle salle) {
    try {
      return salleRepository.save(salle);
    } catch (Exception e) {
      return new Salle();
    }
  }

  public void deleteSalle(String entityId) {
    try {
      int id = Integer.parseInt(entityId);
      salleRepository.deleteById(id);
    } catch (Exception e) {
      return;
    }
  }
}
