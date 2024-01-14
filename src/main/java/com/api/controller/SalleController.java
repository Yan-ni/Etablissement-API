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
import com.api.model.Salle;
import com.api.service.SalleService;
import com.api.service.UtilisateurService;

@RestController
@RequestMapping("/salle")
public class SalleController {
  @Autowired
  SalleService salleService;

  @Autowired
  UtilisateurService utilisateurService;

  @GetMapping
  public ResponseEntity<?> getAllSalle(@RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.RG))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(salleService.getAllSalle());
  }

  @GetMapping("/{entityId}")
  public ResponseEntity<?> getSalle(@PathVariable String entityId, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.RG))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(salleService.getSalle(entityId));
  }

  @PostMapping
  public ResponseEntity<?> addSalle(@RequestBody Salle salle, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.RG))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(salleService.addSalle(salle));
  }

  @PutMapping
  public ResponseEntity<?> editSalle(@RequestBody Salle salle, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.RG))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(salleService.updateSalle(salle));
  }

  @DeleteMapping("/{entityId}")
  public ResponseEntity<String> deleteSalle(@PathVariable String entityId, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.RG))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    salleService.deleteSalle(entityId);
    return ResponseEntity.ok("OK");
  }
}
