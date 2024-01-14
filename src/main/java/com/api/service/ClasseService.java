package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.Classe;
import com.api.repository.ClasseRepository;

@Service
public class ClasseService {

  @Autowired
  ClasseRepository classeRepository;

  public List<Classe> getAllClasse() {
    Iterable<Classe> iterable = classeRepository.findAll();
    List<Classe> result = new ArrayList<Classe>();
    iterable.forEach(result::add);
    return result;
  }

  public Optional<Classe> getClasse(String entityId) {
    int id = Integer.parseInt(entityId);
    return classeRepository.findById(id);
  }

  public Classe addClasse(Classe classe) {
    return classeRepository.save(classe);
  }

  public Classe updateClasse(Classe classe) {
    try {
      return classeRepository.save(classe);
    } catch (Exception e) {
      return new Classe();
    }
  }

  public void deleteClasse(String entityId) {
    try {
      int id = Integer.parseInt(entityId);
      classeRepository.deleteById(id);
    } catch (Exception e) {
      return;
    }
  }
}
