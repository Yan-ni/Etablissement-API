package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import com.api.model.Role;
import com.api.model.Classe;
import com.api.service.ClasseService;
import com.api.service.UtilisateurService;

@RestController
@RequestMapping("/classe")
public class ClasseController {
  @Autowired
  ClasseService classeService;

  @Autowired
  UtilisateurService utilisateurService;

  @GetMapping
  public ResponseEntity<?> getAllClasse(@RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.RG))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(classeService.getAllClasse());
  }

  @GetMapping("/{entityId}")
  public ResponseEntity<?> getClasse(@PathVariable String entityId, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.RG))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(classeService.getClasse(entityId));
  }

  @PostMapping
  public ResponseEntity<?> addClasse(@RequestBody Classe classe, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.RG))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(classeService.addClasse(classe));
  }

  @PutMapping
  public ResponseEntity<?> editClasse(@RequestBody Classe classe, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.RG))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(classeService.updateClasse(classe));
  }

  @DeleteMapping("/{entityId}")
  public ResponseEntity<String> deleteClasse(@PathVariable String entityId, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.RG))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    classeService.deleteClasse(entityId);
    return ResponseEntity.ok("OK");
  }
}
