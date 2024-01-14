package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.TypeSalle;
import com.api.repository.TypeSalleRepository;

@Service
public class TypeSalleService {

  @Autowired
  TypeSalleRepository typeSalleRepository;

  public List<TypeSalle> getAllTypeSalle() {
    Iterable<TypeSalle> iterable = typeSalleRepository.findAll();
    List<TypeSalle> result = new ArrayList<TypeSalle>();
    iterable.forEach(result::add);
    return result;
  }

  public Optional<TypeSalle> getTypeSalle(String entityId) {
    int id = Integer.parseInt(entityId);
    return typeSalleRepository.findById(id);
  }

  public TypeSalle addTypeSalle(TypeSalle typeSalle) {
    return typeSalleRepository.save(typeSalle);
  }

  public TypeSalle updateTypeSalle(TypeSalle ts) {
    try {
      return typeSalleRepository.save(ts);
    } catch (Exception e) {
      return new TypeSalle();
    }
  }

  public void deleteTypeSalle(String entityId) {
    try {
      int id = Integer.parseInt(entityId);
      typeSalleRepository.deleteById(id);
    } catch (Exception e) {
      return;
    }
  }
}
